package com.roitraining.demos.webfluxdemo.domain;

public class ScreenParameters {
    private Long parameterId;
    private String parameterName;
    private Integer minValue;
    private Integer maxValue;
    private Integer equalToValue;

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getEqualToValue() {
        return equalToValue;
    }

    public void setEqualToValue(Integer equalToValue) {
        this.equalToValue = equalToValue;
    }
}
