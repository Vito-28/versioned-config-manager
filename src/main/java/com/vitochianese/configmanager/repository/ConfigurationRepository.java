package com.vitochianese.configmanager.repository;


import com.vitochianese.configmanager.model.Configuration;

import java.util.List;

public interface ConfigurationRepository {
    public void save(Configuration config);
    public Configuration findByName(String name);
    public List<Configuration> findAllConfigurations();
}
