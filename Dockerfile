FROM 092574054921.dkr.ecr.eu-west-1.amazonaws.com/remote/dockerhub/library/amazoncorretto:25-alpine-jdk AS base-jdk

RUN apk add --no-cache binutils

RUN $JAVA_HOME/bin/jlink \
    --verbose \
    --module-path $JAVA_HOME/jmods \
    --add-modules ALL-MODULE-PATH \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /minimized-jre

FROM 092574054921.dkr.ecr.eu-west-1.amazonaws.com/remote/dockerhub/library/alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=base-jdk /minimized-jre $JAVA_HOME

COPY ./build/libs/*boot.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]