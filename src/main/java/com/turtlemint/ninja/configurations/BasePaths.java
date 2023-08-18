package com.turtlemint.ninja.configurations;

public enum BasePaths {
    API("/api"),
    MINTPRO_MASTERS("/api/masters/"),
    MINTPRO_MASTERS_MOTOR("/api/masters/motor"),
    MINTPRO_MASTERS_V1("/api/masters/v1"),
    MINTPRO_PLATFORM_V0("/api/platform/v0/premiums"),
    MINTPRO_APP_LEADS("/api/leads"),
    MINTPRO_APP_INTERNAL("/api/leads"),
    MINTPRO_APP_REDIRECT("/api/v2/partners/"),
    MINTPRO_CHECKOUT("/api/checkout"),
    MINTPRO_PARTNER("api/internal/partners/notification-info");

    private final String basePath;

    public String getBasePath() {
        return this.basePath;
    }

    BasePaths(String basePath) {
        this.basePath = basePath;
    }
}
