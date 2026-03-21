FROM 092574054921.dkr.ecr.eu-west-1.amazonaws.com/remote/dockerhub/library/gradle:9.4.0-jdk25-alpine AS builder
RUN ls -a
ENTRYPOINT ["which", "gradle"]