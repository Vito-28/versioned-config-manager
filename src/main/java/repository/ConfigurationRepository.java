package main.java.repository;

import main.java.model.Configuration;

public interface ConfigurationRepository {
    public void save(Configuration config);
    public Configuration findByName(String name);
}
