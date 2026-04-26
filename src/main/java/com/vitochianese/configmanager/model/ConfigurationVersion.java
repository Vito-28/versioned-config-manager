package com.vitochianese.configmanager.model;

public class ConfigurationVersion {
    private Integer versionNumber;
    private String content;
    private boolean isActive;

    public ConfigurationVersion() {
    }

    public ConfigurationVersion(Integer versionNumber, String content) {
        this.versionNumber = versionNumber;
        this.content = content;
        this.isActive = false;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Version " + versionNumber + ": " + content + ", " + isActive;
    }
}
