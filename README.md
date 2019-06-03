# spring-framework-01-homework
Используются три сервиса TestService, StudentService, TestingService
Все зарегистрированы как Spring Beans (для TestService по необходимости (DI TestDao), 
два оставшихся - авансом в духе фреймворка)
Только один dao для Test; Student и TestReport нигде не хранятся - поэтому для них нет dao.
Производится валидация вводимых пользователем данных
Немного юмора в предлагаемых в тесте вопросах
Покрыть тестированием не успел
