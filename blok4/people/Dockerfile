FROM icr.io/appcafe/open-liberty:kernel-slim-java21-openj9-ubi-minimal

COPY --chown=1001:0 target/liberty/wlp/usr/shared/resources/mysql-connector*.jar /opt/ol/wlp/usr/shared/resources/mysql-connector.jar
COPY --chown=1001:0 /src/main/liberty/config /config

RUN features.sh
COPY --chown=1001:0 target/*.war /config/dropins
RUN configure.sh
