import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class FirstDemos {
    @Test
    void firstPublishDemo() {
        Mono.just(UUID.randomUUID()).subscribe(System.out::println);
    }
}
