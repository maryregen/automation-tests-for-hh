#!/usr/bin/env bash

# Выбираем опции Gradle в зависимости от типа запускаемых тестов
# - API-тесты запускаем без параметризации
# - UI-тесты запускаем с передачей BROWSER_PLATFORM, BROWSER_VERSION, BROWSER_SIZE, REMOTE_URL
# - Mobile-тесты запускаем с deviceHost (browserstack)
#
# Например:
#
# ./gradlew clean api_tests
# ./gradlew clean ui_tests -Dbrowser=CHROME -Dversion=112.0 -DwindowSize=1920x1080 -DremoteUrl=http://localhost:4444/wd/hub
# ./gradlew clean mobile_tests -DdeviceHost=browserstack

set -x 

echo "==> Running ${TEST_TYPE}..."

gradle_opts=""

case "$TEST_TYPE" in 
  "ui_tests")
    BROWSER_PLATFORM=$(echo "${BROWSER}" | awk '{print $1}')
    BROWSER_VERSION=$(echo "${BROWSER}" | awk '{print $2}')

    gradle_opts="-Denv=remote -Dbrowser=${BROWSER_PLATFORM} -Dversion=${BROWSER_VERSION} -DwindowSize=${BROWSER_SIZE} -DremoteUrl=${REMOTE_URL}"
  ;;
  "mobile_tests")
    gradle_opts="-DdeviceHost=browserstack"
  ;;
  "api_tests")
  ;;
esac

if [[ -n $gradle_opts ]] ; then
  ./gradlew clean "$TEST_TYPE" "$gradle_opts"
else
  ./gradlew clean "$TEST_TYPE"
fi
