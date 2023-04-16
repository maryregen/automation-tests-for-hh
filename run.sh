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
################################################################################

set -x

################################################################################

TEST_TYPE="$1"
GRADLE_OPTS="${GRADLE_OPTS}"

################################################################################

if [[ -z $TEST_TYPE ]] ; then
    echo "Error: TEST_TYPE must be set" >&2
    exit 1
fi

echo "==> Running ${TEST_TYPE}..."

case "$TEST_TYPE" in 
  "ui_tests")
    if [[ -z $BROWSER ]] ; then
      echo "Error: BROWSER must be set" >&2
      exit 1
    fi

    if [[ -z $BROWSER_SIZE ]] ; then
      echo "Error: BROWSER_SIZE must be set" >&2
      exit 1
    fi

    BROWSER_PLATFORM=$(echo "${BROWSER}" | awk '{print $1}')
    BROWSER_VERSION=$(echo "${BROWSER}" | awk '{print $2}')

    GRADLE_OPTS="${GRADLE_OPTS} -Dbrowser=${BROWSER_PLATFORM}"
    GRADLE_OPTS="${GRADLE_OPTS} -Dversion=${BROWSER_VERSION}"
    GRADLE_OPTS="${GRADLE_OPTS} -DwindowSize=${BROWSER_SIZE}"

    if [[ -n $REMOTE_URL ]] ; then
      GRADLE_OPTS="${GRADLE_OPTS} -Denv=remote -DremoteUrl=${REMOTE_URL}"
    else
      GRADLE_OPTS="${GRADLE_OPTS} -Denv=local"
    fi
  ;;
  "mobile_tests")
    GRADLE_OPTS="-DdeviceHost=browserstack"
  ;;
  "api_tests")
  ;;
  *)
    echo "Error: unable to run unknown tasks. Only ui_tests, mobile_tests, and api_tests are possible" >&2
    exit 1
  ;;
esac

./gradlew clean "$TEST_TYPE" $GRADLE_OPTS
