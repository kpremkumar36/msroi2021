import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;


public class TestFluxFeatures {

    @Test
    void generatePublish() {
        Flux<String> strPublisher = Flux.generate(AtomicInteger::new,
                (mutableInt, publishIt) -> {
                    publishIt.next(String.format("Next value: %s", mutableInt.getAndIncrement()));
                    if (mutableInt.get() == 15) {
                        publishIt.error(new ArithmeticException("Dangerous Mutable Int " + mutableInt));
                    }
                    if (mutableInt.get() == 17) {
                        publishIt.complete();
                    }
                    return mutableInt;
                });


        strPublisher.subscribe(
                s -> System.out.printf("Subscriber received:: %s%n", s),
                e -> System.out.println("Error published:: " + e),
                () -> System.out.println("Complete notification sent!"));
    }

    @Test
    void testFluxScheduler() {
        Scheduler reactScheduler = Schedulers.newParallel("pub-parallel", 4); final Flux<String> phrasePublish =
                Flux.range(1,20)
                        .map( i -> 42 + i) .publishOn(reactScheduler) .map(m -> {
                            var v = Thread.currentThread().getName();
                            return String.format("%s value produced::%s",v,m);});
        Runnable r0 = ()-> phrasePublish.subscribe(
                n -> {System.out.printf("subscriber recvd:: %s%n",n);});
            r0.run();
    }

}
