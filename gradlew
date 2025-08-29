##!/usr/bin/env sh

# Gradle Wrapper script

DIR=$(cd "$(dirname "$0")" && pwd)
java -jar "$DIR/gradle/wrapper/gradle-wrapper.jar" "$@"
