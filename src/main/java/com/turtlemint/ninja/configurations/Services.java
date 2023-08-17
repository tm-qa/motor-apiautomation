package com.turtlemint.ninja.configurations;

public enum Services {
    MINTPRO_APP("mintproApp"),
    MINTPRO("mintPro"),
    AGENTPRO("agentPro"),
    NINJA("ninja"),
    TANGLED("tangeled");

    private final String serviceName;

    public String getService() {
        return serviceName;
    }

    Services(String serviceName) {
        this.serviceName = serviceName;
    }
}
