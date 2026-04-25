package main.java.service;

import main.java.exception.ConfigurationNotFoundException;
import main.java.model.Configuration;
import main.java.model.ConfigurationVersion;
import main.java.repository.ConfigurationRepository;
import main.java.repository.InMemoryConfigurationRepository;

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
