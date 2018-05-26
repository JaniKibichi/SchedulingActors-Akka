#!/bin/bash

echo "=================================================Removing Target before making assembly ==>"
rm -rf ../target && rm -rf docker/*
echo "=================================Entering schedulingActors directory, creating assembly ==>"
cd ../ && sbt assembly
echo "=====================================================Coming back to dockerApp directory ==>"
cd dockerApp
echo "===============================================Copying application jar to docker folder ==>"
sudo cp ../target/scala-2.11/SchedulingActors-Akka-assembly-1.0.jar docker/
echo "==================================================================Building Docker Image ==>"
sudo docker build -t akkaapp .
echo "===============================================================Running docker container ==>"
sudo docker run akkaapp