#!/bin/bash
set -e

cp gradle.properties.example gradle.properties
sed -i "s/sonatypeUsername=/sonatypeUsername=$SONATYPE_USERNAME" gradle.properties
sed -i "s/sonatypePassword=/sonatypePassword=$SONATYPE_PASSWORD" gradle.properties

./gradlew build -x test
./gradlew uploadArchives

exit 0
