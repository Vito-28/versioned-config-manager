package main.java.exception;

public class ConfigurationNotFoundException extends Exception{

    public ConfigurationNotFoundException(String configurationNotFound) {
        System.out.println(configurationNotFound);
    }
}
