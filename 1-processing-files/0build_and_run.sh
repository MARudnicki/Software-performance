#!/usr/bin/env bash

### build
./gradlew clean
./gradlew build -x test

### run with params
java -jar -Xmx300M ./build/libs/1-processing-files-0.0.1-SNAPSHOT.jar
