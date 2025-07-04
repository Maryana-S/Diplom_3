# Diplom_3

Дипломный проект UI-автотестов для [Stellar Burgers](https://stellarburgers.nomoreparties.site/)

Технологии, используемые в проекте:

|  **_Name_**   | Java | Maven | Selenium WebDriver | JUnit  | REST Assured | Allure | Gson  | AspectJ | Lombok  |
|:-------------:|:----:|:-----:|:------------------:|:------:|:------------:|:------:|:-----:|---------|:-------:|
| **_Version_** |  11  | 4.0.0 |       4.31.0       | 4.13.2 |    5.5.5     | 2.29.1 | 2.3.1 | 1.9.24  | 1.18.38 |

Запуск автотестов в Chrome: ````mvn clean test````

Запуск автотестов в Yandex.Browser: ````mvn clean test -Ddriver.path=yandexdriver.exe````

yandexdriver.exe - путь до драйвера; если драйвер не указан, используется по умолчанию - Chrome

Allure отчет: ````mvn allure::serve```` 
