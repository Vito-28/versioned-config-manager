package com.vitochianese.configmanager;


import com.vitochianese.configmanager.exception.ConfigurationNotFoundException;
import com.vitochianese.configmanager.model.Configuration;
import com.vitochianese.configmanager.model.ConfigurationVersion;
import com.vitochianese.configmanager.service.ConfigurationService;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
//        ConfigurationRepository repository = new InMemoryConfigurationRepository();
//        Configuration configuration = new Configuration("database-config"),
//                      configuration1 = new Configuration("application-config");

        try{
            ConfigurationService service = new ConfigurationService();
            service.createConfiguration("database-config");
            service.createConfiguration("application-config");

            Configuration configuration = service.getConfigurationByName("database-config"),
                          configuration1 = service.getConfigurationByName("application-config");

            service.addVersion(new ConfigurationVersion(1, "db.host=localhost"), configuration);
            service.addVersion(new ConfigurationVersion(2, "db.host=db.company.com"), configuration);
            service.addVersion(new ConfigurationVersion(3, "db.host=cloud-db"), configuration);

            service.addVersion(new ConfigurationVersion(1, "app.name=MyApp"), configuration1);
            service.addVersion(new ConfigurationVersion(2, "app.name=SmartApp"), configuration1);
            service.addVersion(new ConfigurationVersion(3, "app.name=IoTApp"), configuration1);

            service.save();

            System.out.println("Repository: ");
            System.out.println(service.getAllConfigurations());

            service.rollbackVersion(new ConfigurationVersion(1, "db.host=localhost"), configuration);
            service.rollbackVersion(new ConfigurationVersion(2, "app.name=SmartApp"), configuration1);

            System.out.println("Repository: ");
            System.out.println(service.getAllConfigurations());


        }catch (ConfigurationNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        configuration.addVersion(new ConfigurationVersion(1, "db.host=localhost"));
//        configuration.addVersion(new ConfigurationVersion(2, "db.host=db.company.com"));
//        configuration.addVersion(new ConfigurationVersion(3, "db.host=cloud-db"));

//        configuration1.addVersion(new ConfigurationVersion(1, "app.name=MyApp"));
//        configuration1.addVersion(new ConfigurationVersion(2, "app.name=SmartApp"));
//        configuration1.addVersion(new ConfigurationVersion(3, "app.name=IoTApp"));

//        for(ConfigurationVersion version : configuration.getVersions()) {
//            System.out.println("Version: " + version.getVersionNumber());
//            System.out.println(version.getContent());
//        }

//        repository.save(configuration);
//
//        repository.save(configuration1);
//
//        Configuration loaded = repository.findByName("database-config");
//
//        System.out.println(loaded);
//
//        Configuration loaded1 = repository.findByName("application-config");
//
//        System.out.println(loaded1);



    }
}