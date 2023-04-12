package ui.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    //зачитываем данные из командной строки
    @Key("baseUrl")
    // обрабатывает дефолтное значение
    @DefaultValue("https://hh.ru")
    // конвертируем в возращаемый тип
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

}
