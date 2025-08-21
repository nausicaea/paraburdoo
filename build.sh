#!/bin/sh

exec docker build \
    -t nausicaea/paraburdoo:local \
    --build-arg "MINECRAFT_VERSION=$MINECRAFT_VERSION" \
    --build-arg "FABRIC_LOADER_VERSION=$FABRIC_LOADER_VERSION" \
    --build-arg "YARN_MAPPINGS_VERSION=$YARN_MAPPINGS_VERSION" \
    .

