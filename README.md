# Table of Contents
- [Introduction](#introduction)
- [Run](#Run)
- [Reference](#Reference)

# Introduction

Calculate Guassian sum 1 + 2 + ... + 1000 = 500500 by docker

# Run
Step 1: Fire up service
docker-compose up

Step 2: Run test

a) curl http://127.0.0.1:80/ping
Result: 'Pong'

b) curl http://127.0.0.1:80/hello-world
Result: '{"id":1,"content":"Hello, Stranger!"}'

c) curl http://127.0.0.1:80/hello-world?name=Disney-World
Result: '{"id":1,"content":"Hello, Disney-World!"}'

d) curl -H "Content-Type: application/json" -X POST --data '{"x":11,"y":22}' http://localhost:80/sum
Result: '{"sum":33}'

e) python test/run.py
Result: 'sum: 500500'

Step 3: Clean up
Command: docker-compose down

# Reference
The Java code is adapted from https://spring.io/guides/gs/actuator-service/
