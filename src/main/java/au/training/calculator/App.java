package au.training.calculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        System.out.println("AI Calculator v0.1");
        System.out.println("2 + 3 = " + add(2, 3));
        System.out.println("10 - 4 = " + subtract(10, 4));
        System.out.println("5 x 6 = " + multiply(5, 6));
        System.out.println("20 / 4 = " + divide(20, 4));

        Properties config = loadConfig(args);
        if (!config.isEmpty()) {
            System.out.println("Environment: " + config.getProperty("environment.name", "Not specified"));
            System.out.println("Database: " + config.getProperty("database.path", "Not specified"));
            System.out.println("Security mode: " + config.getProperty("security.mode", "Not specified"));
            System.out.println("Debug enabled: " + config.getProperty("debug.enabled", "Not specified"));
        }

        String appEnv = System.getenv("APP_ENV");
        if (appEnv != null && !appEnv.isBlank()) {
            System.out.println("Deployment variable APP_ENV: " + appEnv);
        }
    }

    private static Properties loadConfig(String[] args) {
        Properties properties = new Properties();
        String configPath = null;

        for (String arg : args) {
            if (arg.startsWith("--config=")) {
                configPath = arg.substring("--config=".length());
            }
        }

        if (configPath == null || configPath.isBlank()) {
            return properties;
        }

        try (FileInputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Configuration file could not be loaded: " + configPath);
        }

        return properties;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
