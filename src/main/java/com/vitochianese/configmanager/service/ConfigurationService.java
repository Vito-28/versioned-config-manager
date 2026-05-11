package com.vitochianese.configmanager.service;

import com.vitochianese.configmanager.exception.ConfigurationNotFoundException;
import com.vitochianese.configmanager.model.Configuration;
import com.vitochianese.configmanager.model.ConfigurationVersion;
import com.vitochianese.configmanager.repository.ConfigurationRepository;
import com.vitochianese.configmanager.repository.InMemoryConfigurationRepository;
import com.vitochianese.configmanager.util.JsonUtil;


import java.io.IOException;
import java.util.List;

public class ConfigurationService {
    private final ConfigurationRepository repository;
    private final JsonUtil jsonUtil;

    public ConfigurationService() throws IOException {
        this.repository = new InMemoryConfigurationRepository();
        this.jsonUtil = new JsonUtil();
    }

    public ConfigurationRepository getRepository() {
        return repository;
    }

    public Configuration getConfigurationByName(String name) {
        return repository.findByName(name);
    }

    public List<Configuration> getAllConfigurations() {
        return repository.findAllConfigurations();
    }

    public void save() throws IOException {
        jsonUtil.saveToFile(repository.findAllConfigurations());
    }

    public List<Configuration> load() throws IOException {
        return jsonUtil.loadFromFile();
    }

    public void createConfiguration(String name) throws IOException {
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

    public void rollbackVersion(ConfigurationVersion version, Configuration configuration) throws ConfigurationNotFoundException, IOException {
        if(configuration == null) {
            throw new ConfigurationNotFoundException("Configuration not found!");
        }
        repository.findByName(configuration.getName()).getVersions().forEach( v -> v.setActive(v.getContent().equals(version.getContent())));
    }
}
