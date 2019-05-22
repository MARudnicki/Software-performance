#!/usr/bin/env bash

### run with params
curl -d '{"name":"any-name", "password":"some easy password"}' -H "Content-Type: application/json" -X POST http://localhost:8080/accounts
