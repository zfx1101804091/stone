FROM adoptopenjdk/openjdk8-openj9:alpine-slim

MAINTAINER 1875586562@qq.com

RUN mkdir -p /stone/admin

WORKDIR /stone/admin

EXPOSE 9001

ADD ./target/stone-admin.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=dev"]
