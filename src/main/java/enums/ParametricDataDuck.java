package enums;

public enum  ParametricDataDuck {

    RU  ("ru", "Компьютерная школа Hillel в Киеве: курсы IT технологий"),  //calls constructor with value 3
    FR("fr", "Создать сайт бесплатно | Конструктор сайтов | Wix.com"),  //calls constructor with value 2
    ES   ("es", "Top of the day / Habr")   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final String expectedTitle;
    private final String searchParam;

    ParametricDataDuck(String searchParam, String expectedTitle) {
        this.searchParam = searchParam;
        this.expectedTitle = expectedTitle;
    }

    public String getExpectedTitle() {
        return this.expectedTitle;
    }
    public String getCode() {
        return this.searchParam;
    }

}
