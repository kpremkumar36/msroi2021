package com.roitraining.demos.webfluxdemo.domain;

import java.util.List;

public class ScreenInfo {
    private Long screenId;
    private String screenName;
    private String screenDesc;
    private List<ScreenParameters> screenParameters;

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenDesc() {
        return screenDesc;
    }

    public void setScreenDesc(String screenDesc) {
        this.screenDesc = screenDesc;
    }

    public List<ScreenParameters> getScreenParameters() {
        return screenParameters;
    }

    public void setScreenParameters(List<ScreenParameters> screenParameters) {
        this.screenParameters = screenParameters;
    }
}
