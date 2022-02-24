#!/usr/bin/env bash

mvn clean install -DskipTests
docker-compose rm -vfs
#docker-compose down --rmi all
docker-compose up -d --force-recreate --build