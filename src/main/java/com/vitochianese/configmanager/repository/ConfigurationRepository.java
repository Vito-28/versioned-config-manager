package com.vitochianese.configmanager.repository;


import com.vitochianese.configmanager.model.Configuration;

public interface ConfigurationRepository {
    public void save(Configuration config);
    public Configuration findByName(String name);
}
