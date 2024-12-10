package com.infosupport;

import org.microshed.testing.SharedContainerConfiguration;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class AppDeploymentConfig implements SharedContainerConfiguration {

    @Container
    public static MySQLContainer<?> mysql;
    static String databaseName = "people-db";

    static {
        mysql = new MySQLContainer<>("mysql:8.0.30")
                .withEnv("MYSQL_ROOT_PASSWORD", "root")
                .withExposedPorts(3306)
                .withDatabaseName(databaseName)
                .withUsername("root")
                .withPassword("root")
                .withNetworkAliases("mysql-container-it");
    }

    // create docker container based on the Dockerfile
    @Container
    public static ApplicationContainer app = new ApplicationContainer()
            .withAppContextRoot("/people")
            .withExposedPorts(9080)
            .withEnv("MYSQL_HOSTNAME", "mysql-container-it")
            .withEnv("MYSQL_PORT", "3306")
            .withEnv("MYSQL_DATABASE", databaseName)
            .withReadinessPath("/health/ready")
            .dependsOn(mysql);
}
