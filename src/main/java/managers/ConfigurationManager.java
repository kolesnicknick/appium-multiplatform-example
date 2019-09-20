package managers;

public class ConfigurationManager {
    private static ConfigurationManager holder;

    private ConfigurationManager(){

    }

    public static ConfigurationManager getInstance(){
        return holder == null ? new ConfigurationManager() : holder;
    }

    public String getPlatformVersion(){return getEnvironmentVariableValueOrDefault("platformVersion", "12.4");}
    public String getMobilePlatform(){return getEnvironmentVariableValueOrDefault("platform", "Android");}
    public String getDeviceName(){return getEnvironmentVariableValueOrDefault("deviceName", "iPhone XR");}


    private String getEnvironmentVariableValueOrDefault(String envVar, String defValue){
        String value = System.getenv(envVar);
        return value != null ? value : defValue;
    }

}
