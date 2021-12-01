package com.roitraining.demos.webfluxdemo.persistence;

import com.roitraining.demos.webfluxdemo.domain.ScreenInfo;
import com.roitraining.demos.webfluxdemo.domain.ScreenParameters;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScreenDAO {
    public Flux<List<ScreenInfo>> findAllScreens() {
        List<ScreenInfo> screens = new ArrayList<>();

        ScreenInfo screen1 = getScreenInfo(1L);
        screens.add(screen1);

        ScreenInfo screen2 = getScreenInfo(2L);
        screens.add(screen2);

        ScreenInfo screen3 = getScreenInfo(3L);
        screens.add(screen3);
        return Flux.just(screens);
    }

    public Mono<ScreenInfo> findScreenById(Long screenId) {
        ScreenInfo screenInfo = getScreenInfo(screenId);
        screenInfo.setScreenParameters(getAllScreenParameters(screenId));
        return Mono.just(screenInfo);
    }

    private ScreenInfo getScreenInfo(Long screenId) {
        ScreenInfo screen = new ScreenInfo();
        screen.setScreenId(screenId);
        screen.setScreenName("PKScreen" + screenId);
        screen.setScreenDesc("WebFlux Demo Screen" + screenId);
        return screen;
    }

    private List<ScreenParameters> getAllScreenParameters(Long screenId) {
        List<ScreenParameters> screenParameters = new ArrayList<>();
        ScreenParameters parameters1 = new ScreenParameters();
        parameters1.setParameterId(screenId);
        parameters1.setParameterName("volatility");
        parameters1.setMinValue(10);
        parameters1.setMaxValue(20);

        ScreenParameters parameters2 = new ScreenParameters();
        parameters2.setParameterId(screenId);
        parameters2.setParameterName("price/volume ratio");
        parameters2.setMinValue(30);
        parameters2.setMaxValue(40);

        screenParameters.add(parameters1);
        screenParameters.add(parameters2);
        return screenParameters;
    }
}
