package mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface AuthConfig extends Config {
    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();
}
