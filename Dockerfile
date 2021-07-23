#Build environment
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
WORKDIR /build/

COPY pom.xml /build/
COPY checkstyle.xml /build/
COPY src /build/src/
#RUN mvn -B -f ./pom.xml -s  dependency:resolve
RUN mvn -B -f ./pom.xml package -DskipTests
# RUN mvn validate 
# RUN mvn clean install --quiet -DskipTests

#Production packaging
FROM openjdk:8-jre-alpine
MAINTAINER Stephen Obi stephen.obi@obikobefarms.com
WORKDIR /app
COPY config/* /app/config/
COPY --from=MAVEN_BUILD /build/target/backend-service*.jar /app/backend-service.jar
ENTRYPOINT ["java", "-jar", "backend-service.jar"]



#docker build --rm -t backend-service:2.0.2

#$ docker image prune -f

#docker service create --name backend-service --publish 5555:5555 --replicas 2 --log-driver=fluentd --log-opt fluentd-address=172.17.10.83:24224 --log-opt tag=docker.payoutlet.central.service backend-service:$BUILD_NUMBER

#sh 'docker service update --image backend-service:"$BUILD_NUMBER" backend-service'