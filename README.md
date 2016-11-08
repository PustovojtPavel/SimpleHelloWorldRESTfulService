## Запуск локального сервера на jetty в IntelliJ IDEA

1. Включить профиль `server-jetty` в мавене;
2. Настроить конфигурацию запуска типа "Application" с параметрами:
    - класс `org.eclipse.jetty.runner.Runner`,
    - аргументы приложения `src/test/config/jetty/dev.xml`,
    - рабочая директория `path/to/project`,
    - использовать `CLASSPATH` модуля `JerseyRESTFulService`.
