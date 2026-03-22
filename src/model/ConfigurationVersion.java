package model;

public class ConfigurationVersion {
    private Integer versionNumber;
    private String content;

    public ConfigurationVersion() {
    }

    public ConfigurationVersion(Integer versionNumber, String content) {
        this.versionNumber = versionNumber;
        this.content = content;
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
}
