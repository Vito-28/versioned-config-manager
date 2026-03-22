import model.Configuration;
import model.ConfigurationVersion;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration("database-config");

        configuration.addVersion(new ConfigurationVersion(1, "db.host=localhost"));
        configuration.addVersion(new ConfigurationVersion(2, "db.host=db.company.com"));
        configuration.addVersion(new ConfigurationVersion(3, "db.host=cloud-db"));

        for(ConfigurationVersion version : configuration.getVersions()) {
            System.out.println("Version: " + version.getVersionNumber());
            System.out.println(version.getContent());
        }
    }
}