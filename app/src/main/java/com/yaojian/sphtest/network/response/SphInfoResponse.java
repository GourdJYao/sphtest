package com.yaojian.sphtest.network.response;

public class SphInfoResponse {
    private String help;
    private Boolean success;
    private ResultInfo result;

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ResultInfo getResult() {
        return result;
    }

    public void setResult(ResultInfo result) {
        this.result = result;
    }
}
