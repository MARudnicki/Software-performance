#!/usr/bin/env bash

### build
./gradlew clean
./gradlew build -x test

### run with params
java -jar -Xmx80M ./build/libs/bookstore-0.0.1-SNAPSHOT.jar
