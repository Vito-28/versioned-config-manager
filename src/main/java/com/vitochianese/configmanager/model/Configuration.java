package com.vitochianese.configmanager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Configuration {
    private String name;
    private List<ConfigurationVersion> versions;

    public Configuration() {
    }

    public Configuration(String name, List<ConfigurationVersion> versions) {
        this.name = name;
        this.versions = versions;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(name, that.name) && Objects.equals(versions, that.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, versions);
    }

    @Override
    public String toString() {
        return "Configuration: " + name + " Versions: " + versions;
    }
}
