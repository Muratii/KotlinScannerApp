#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
exec java -jar "$DIR/gradle/wrapper/gradle-wrapper.jar" "$@"
