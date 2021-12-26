FROM alpine
RUN apk add openjdk11
ENV PATH $PATH:/usr/lib/jvm/java-11.0-openjdk/bin
WORKDIR D:\Shared\Study\Dockerworkspace
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD local_testng.xml local_testng.xml
ADD pom.xml pom.xml
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE