# Example Project for Micronaut 3, Packaged as WAR

This Micronaut template project is designed to work with the following versions
- Micronaut 3.10.4
- Java 1.8
- ojdbc8

## Usage

### Running Tests
Run this command
```
./gradlew clean test
```

### Building the WAR
Run this command
```
./gradlew clean war
```

The WAR file is generated in this directory
```
./buid/libs/
```

### Running the Application Locally
Edit `build.gradle`, set the following config
```
def useNetty = false
```

Run this command
```
./gradlew clean run
```

## Micronaut 3.10.4 Documentation

- [User Guide](https://docs.micronaut.io/3.10.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.10.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.10.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
## Feature annotation-api documentation

- [https://jakarta.ee/specifications/annotations/](https://jakarta.ee/specifications/annotations/)


## Feature jdbc-ucp documentation

- [Micronaut Oracle UCP JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#nettyHttpClient)


## Feature data-jdbc documentation

- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


