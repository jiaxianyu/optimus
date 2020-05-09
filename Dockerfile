FROM openjdk:8

WORKDIR /home


COPY ./deepexi-spring-cloud-provider/target/app.jar /home

ADD entrypoint.sh /

RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
