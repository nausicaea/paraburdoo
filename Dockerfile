# syntax=docker/dockerfile:1

### Builds the Opentelemetry integration as a mod for fabric
FROM docker.io/library/gradle:8.14.2-jdk21-alpine
ARG MINECRAFT_VERSION
ARG YARN_MAPPINGS_VERSION
ARG FABRIC_LOADER_VERSION
WORKDIR /src
COPY --link ./build.gradle ./settings.gradle ./gradle.properties /src/
COPY --link ./src /src/src
RUN --mount=type=cache,target=/root/.gradle --mount=type=cache,target=/src/.gradle gradle --no-daemon --build-cache --info :dependencies
RUN --mount=type=cache,target=/root/.gradle --mount=type=cache,target=/src/.gradle gradle --no-daemon --build-cache --info :assemble
WORKDIR /artefacts
RUN cp /src/build/libs/*.jar /artefacts/
