package com.vitochianese.configmanager.repository;

import com.vitochianese.configmanager.model.Configuration;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Configuration> findAllConfigurations() {
        return storage.values().stream().toList();
    }
}
