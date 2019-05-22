#!/usr/bin/env bash

### build jar
./gradlew clean
./gradlew build -x test

### docker build
docker build -t scaling:latest .

### run with params
#java -jar -Xmx80M ./build/libs/reading-0.0.1-SNAPSHOT.jar
