import model.Configuration;
import model.ConfigurationVersion;
import repository.ConfigurationRepository;
import repository.InMemoryConfigurationRepository;

public class Main {
    public static void main(String[] args) {
        ConfigurationRepository repository = new InMemoryConfigurationRepository();
        Configuration configuration = new Configuration("database-config"),
                      configuration1 = new Configuration("application-config");

        configuration.addVersion(new ConfigurationVersion(1, "db.host=localhost"));
        configuration.addVersion(new ConfigurationVersion(2, "db.host=db.company.com"));
        configuration.addVersion(new ConfigurationVersion(3, "db.host=cloud-db"));

        configuration1.addVersion(new ConfigurationVersion(1, "app.name=MyApp"));
        configuration1.addVersion(new ConfigurationVersion(2, "app.name=SmartApp"));
        configuration1.addVersion(new ConfigurationVersion(3, "app.name=IoTApp"));

//        for(ConfigurationVersion version : configuration.getVersions()) {
//            System.out.println("Version: " + version.getVersionNumber());
//            System.out.println(version.getContent());
//        }

        repository.save(configuration);

        repository.save(configuration1);

        Configuration loaded = repository.findByName("database-config");

        System.out.println(loaded);

        Configuration loaded1 = repository.findByName("application-config");

        System.out.println(loaded1);

    }
}