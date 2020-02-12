# DropwizardRest

How to start the DropwizardRest application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/deb-dwrest-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8087`

Health Check
---

To see your applications health enter url `http://localhost:8088/healthcheck`
