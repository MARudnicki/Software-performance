#!/usr/bin/env bash

curl -i -X POST -H "Content-Type: multipart/form-data" -F "file=@world.topo.bathy.200407.3x21600x21600.A2.png" http://localhost:8080/files