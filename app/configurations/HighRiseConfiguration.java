package configurations;

import play.Play;

public class HighRiseConfiguration {
    public static String HIGH_RISE_URL = Play.configuration.getProperty("highrise.api.url");
    public static String HIGH_RISE_AUTH_CODE = "Basic ".concat(Play.configuration.getProperty("highrise.auth"));
}