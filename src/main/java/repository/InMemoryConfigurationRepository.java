package main.java.repository;

import main.java.model.Configuration;
import main.java.repository.ConfigurationRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryConfigurationRepository implements ConfigurationRepository {
    private Map<String, Configuration> storage = new HashMap<>();

    @Override
    public void save(Configuration config) {
        storage.put(config.getName(), config);
    }

    @Override
    public Configuration findByName(String name) {
        return storage.get(name);
    }
}
