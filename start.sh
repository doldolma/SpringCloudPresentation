#!/usr/bin/env bash

mvn clean install -DskipTests
docker-compose rm -vfs
docker-compose up -d --force-recreate --build
# docker-compose up --build -d