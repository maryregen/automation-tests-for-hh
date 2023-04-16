<h1 >Проект по автоматизации тестирования для <a href="https://hh.ru/">HeadHunter</a></h1>

## Содержание

* <a href="#description">Описание</a>
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#selenoidvideo">Пример прогона теста в Selenoid</a>
* <a href="#browserstackvideo">Пример прогона теста в Browserstack</a>

<a id="description"></a>
## Описание
Данный проект состоит из автоматизированных:
* UI-тестов для веб-приложения [hh.ru](https://hh.ru/)
* тестов для [API-части](https://github.com/hhru/api)
* мобильных тестов приложения для Android 

<a id="tools"></a>
## Технологии и инструменты

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/IntelliJ_IDEA.png">
<img width="6%" title="Java" src="images/logo/Java_logo.png">
<img width="6%" title="Selenide" src="images/logo/Selenide.png">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.png">
<img width="6%" title="Allure Report" src="images/logo/AllureReports.png">
<img width="6%" title="Gradle" src="images/logo/Gradle.png">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.png">
<img width="6%" title="GitHub" src="images/logo/GitHub.png">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.png">
<img width="6%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="6%" title="REST Assured" src="images/logo/RestAssured.png">
<img width="6%" title="Android Studio" src="images/logo/AndroidStudio.svg">
<img width="6%" title="Appium" src="images/logo/Appium.svg">
<img width="6%" title="Appium Inspector" src="images/logo/Inspector.png">
<img width="6%" title="Browserstack" src="images/logo/Browserstack.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>, применены различные библиотеки и фреймворки. 

Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона. 
В качестве системы управления тестированием выбран <code>Allure TestOps</code>. 

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

### Для UI-тестов
* при написании использован фреймворк [Selenide](https://selenide.org/)
* запуск осуществляется локально или с помощью [Selenoid](https://aerokube.com/selenoid/).

### Для API-тестов 
* при написании использована библиотека [REST Assured](https://rest-assured.io)
* для сокращения шаблонного кода применена библиотека [Lombok](https://projectlombok.org/)

### Для mobile-тестов 
* при написании использован фреймворк с открытым исходным кодом [Appium](https://appium.io) 
* для просмотра и взаимодействия с элементами интерфейса выбран [Appium Inspector](https://github.com/appium/appium-inspector) 
* запуск может осуществляться локально в эмуляторе [Android Studio](https://developer.android.com/studio)
* удаленный запуск осуществляется с помощью фермы реальных мобильных устройств [Browserstack](https://app-automate.browserstack.com/)

<a id="cases"></a>
## Реализованные проверки

### Автоматизированные проверки UI
- [ ] Проверка смены языка на английский
- [ ] Проверка смены региона
- [ ] Проверка текста для работодателя
- [ ] Проверка текста для соискателя
- [ ] Поиск вакансий по профессии для соискателя
- [ ] Поиск вакансий по компании для соискателя
- [ ] Поиск вакансий по должности в каталоге для соискателя

### Мануальные проверки 
- [ ] Фильтрация по параметру "за сутки" в расширенном фильтре 
- [ ] Страница для работодателя содержит другой текст для работодателя

### Автоматизированные проверки API
- [ ] Проверка статуса ответа метода vacancies
- [ ] Поиск работодателя по определенным словам (параметризация ВкусВилл/СберМаркет)
- [ ] Поиск вакансии по определенным словам (параметризация Продавец/Консультант)
- [ ] Отклик на определенную вакансию без авторизации
- [ ] Удаление комментариев соискателей

### Автоматизированные проверки MOBILE APP 
- [ ] Проверка заголовка главной страницы с вакансиями
- [ ] Поиск вакансий по заданному параметру
- [ ] Вакансия содержит кнопку 'Откликнуться'

<a id="console"></a>
##  Запуск тестов
### Локальный запуск тестов 
#### Для UI-тестов
```
gradle clean ui_tests -Denv=local
```
#### Для API-тестов
```
gradle clean api_tests 
```
#### Для MOBILE-тестов
```
gradle clean mobile_tests -DdeviceHost=emulator
```

### Удаленный запуск тестов
Выбираем опции Gradle в зависимости от типа запускаемых тестов: 
* UI-тесты запускаем с передачей BROWSER_PLATFORM, BROWSER_VERSION, BROWSER_SIZE, REMOTE_URL
* API-тесты запускаем без параметризации
* Mobile-тесты запускаем с deviceHost (browserstack)

Например, 
```
./gradlew clean ui_tests -Dbrowser=CHROME -Dversion=112.0 -DwindowSize=1920x1080 -DremoteUrl=http://localhost:4444/wd/hub
./gradlew clean api_tests 
./gradlew clean mobile_tests -DdeviceHost=browserstack
```
```
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
  ./gradlew clean "$TEST_TYPE" $gradle_opts
else
  ./gradlew clean "$TEST_TYPE"
fi
```

> `${TEST_TYPE}` - тип запускаемых тестов (ui_tests, api_tests, mobile_tests).
> 
> `${BROWSER}` - комбинация браузера и версии (_по умолчанию - <code>chrome 100.0</code>_).
>
> `${BROWSER_PLATFORM}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
> 
> `${BROWSER_VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
> 
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1290x1080</code>_).
>
> `${REMOTE_URL}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/017-maryregen-java-automation-tests-for-hh/)

1. Для запуска сборки необходимо перейти в раздел **Собрать с параметрами** 
2. Запуская ui-тесты, необходимо указать параметры для сборки (путем выбора из списка или прямым указанием значения) и в <code>TEST_TYPE</code> выбрать ui-tests. 
3. Запуская api-тесты или mobile-тесты, можно оставить все предзаполненные поля, поменяв <code>TEST_TYPE</code> соответственно на api_tests или mobile_tests.
4. Нажать кнопку **Собрать**.

<p align="center">
<img src="images/screenshots/JenkinsJob.png"/></a>
</p>

<a id="allure"></a>
## Отчеты в [Allure Report](https://jenkins.autotests.cloud/job/017-maryregen-java-automation-tests-for-hh/16/allure/)

### Прохождение UI-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Прохождение API-тестов
<p align="center">
<img src="images/screenshots/AllureSuitsApi.png">
</p>

### Прохождение mobile-тестов
<p align="center">
<img src="images/screenshots/">
</p>

<a id="testops"></a>
## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1846/dashboards) 

### Прохождение UI-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Прохождение API-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Прохождение mobile-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Пример мануального тест-кейса
<p align="center">
<img src="images/screenshots/TestOpsManualCases.png">
</p>

### Пример запуска тест-кейсов
<p align="center">
<img src="images/screenshots/TestOpsLaunchApi.png">
</p>

<a id="jira"></a>
## Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-514) 
<p align="center">
<img src="images/screenshots/">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота

### Уведомление о прохождении UI-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Уведомление о прохождении API-тестов
<p align="center">
<img src="images/screenshots/">
</p>

### Уведомление о прохождении mobile-тестов
<p align="center">
<img src="images/screenshots/">
</p>

<a id="selenoidvideo"></a>
## Пример прогона UI-теста в Selenoid

К каждому тесту в отчете прилагается видео. 
<p align="center">
  <img src="images/video/VideoGif.gif">
</p>

<a id="browserstackvideo"></a>
## Пример прогона mobile-теста в Browserstack

К каждому тесту в отчете прилагается видео. 
<p align="center">
  <img src="images/video/MobileVideoGif.gif">
</p>