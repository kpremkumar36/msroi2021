package com.roitraining.demos.webfluxdemo.service;

import com.roitraining.demos.webfluxdemo.domain.ScreenInfo;
import com.roitraining.demos.webfluxdemo.domain.ScreenParameters;
import com.roitraining.demos.webfluxdemo.persistence.ScreenDAO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ScreenService {

    private final ScreenDAO screenDAO;

    public ScreenService(ScreenDAO screenDAO) {
        this.screenDAO = screenDAO;
    }

    public Flux<List<ScreenInfo>> getAllScreens() {
        return screenDAO.findAllScreens();
    }

    public Mono<ScreenInfo> getScreenInfo(Long screenId) {
        Mono<ScreenInfo> screenInfo = screenDAO.findScreenById(screenId);
        return screenInfo;
    }
}
