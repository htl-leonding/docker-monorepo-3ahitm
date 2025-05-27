#!/usr/bin/env bash

set -e

mvn clean package

docker build --file ./src/main/docker/Dockerfile -t webserver:latest .
