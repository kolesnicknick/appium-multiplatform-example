package managers;

public class ConfigurationManager {
    private static ConfigurationManager holder;

    private ConfigurationManager(){

    }

    public static ConfigurationManager getInstance(){
        return holder == null ? new ConfigurationManager() : holder;
    }

    public String getPlatformVersion(){return getEnvironmentVariableValueOrDefault("platformVersion", "");}
    public String getMobilePlatform(){return getEnvironmentVariableValueOrDefault("platform", "Android");}

    private String getEnvironmentVariableValueOrDefault(String envVar, String defValue){
        String value = System.getenv(envVar);
        return value != null ? value : defValue;
    }

}
