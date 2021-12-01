package com.roitraining.demos.webfluxdemo.controller;

import com.roitraining.demos.webfluxdemo.domain.ScreenInfo;
import com.roitraining.demos.webfluxdemo.service.ScreenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(path="/screens", produces= MediaType.APPLICATION_JSON_VALUE)
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/all")
    public Flux<List<ScreenInfo>> getScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/{screenId}")
    public Mono<ScreenInfo> getScreenInfo(@PathVariable("screenId") long screenId) {
        return screenService.getScreenInfo(screenId);
    }
}
