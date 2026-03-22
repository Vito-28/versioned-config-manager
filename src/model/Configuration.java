package model;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private String name;
    private List<ConfigurationVersion> versions;

    public Configuration() {
    }

    public Configuration(String name, List<ConfigurationVersion> versions) {
        this.name = name;
        this.versions = new ArrayList<>();
    }

    public Configuration(String name) {
        this.name = name;
        this.versions = new ArrayList<>();
    }

    public void addVersion(ConfigurationVersion version) {
        versions.add(version);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConfigurationVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ConfigurationVersion> versions) {
        this.versions = versions;
    }
}
