package com.vitochianese.configmanager.service;

import com.vitochianese.configmanager.exception.ConfigurationNotFoundException;
import com.vitochianese.configmanager.model.Configuration;
import com.vitochianese.configmanager.model.ConfigurationVersion;
import com.vitochianese.configmanager.repository.ConfigurationRepository;
import com.vitochianese.configmanager.repository.InMemoryConfigurationRepository;


import java.util.List;

public class ConfigurationService {
    private final ConfigurationRepository repository = new InMemoryConfigurationRepository();

    public ConfigurationRepository getRepository() {
        return repository;
    }

    public void createConfiguration(String name) {
        repository.save(new Configuration(name));
    }

    public void addVersion(ConfigurationVersion version, Configuration configuration) throws ConfigurationNotFoundException {
        if(configuration == null) {
            throw new ConfigurationNotFoundException("Configuration not found!");
        }
        repository.findByName(configuration.getName()).addVersion(version);
    }

    public List<ConfigurationVersion> getVersions(Configuration configuration) throws ConfigurationNotFoundException {
        if(configuration == null) {
            throw new ConfigurationNotFoundException("Configuration not found!");
        }
        return repository.findByName(configuration.getName()).getVersions();
    }

    public void rollbackVersion(ConfigurationVersion version, Configuration configuration) throws ConfigurationNotFoundException {
        if(configuration == null) {
            throw new ConfigurationNotFoundException("Configuration not found!");
        }
        repository.findByName(configuration.getName()).getVersions().forEach( v -> v.setActive(v.getContent().equals(version.getContent())));
    }
}
