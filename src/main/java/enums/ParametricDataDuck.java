package enums;

public enum ParametricDataDuck {

    RU("ru", "Создать сайт", "Здесь создают профессиональные сайты"),
    FR("fr", "C'est parti !", "Créer un site internet de qualité professionnelle"),
    ES("es", "Empieza ya", "El Lugar Perfecto para Crear tu Página Web Profesional");

    private final String createButtonTitle;
    private final String signInButtonTitle;
    private final String searchParam;

    ParametricDataDuck(String searchParam, String createButtonTitle, String signInButtonTitle) {
        this.searchParam = searchParam;
        this.createButtonTitle = createButtonTitle;
        this.signInButtonTitle = signInButtonTitle;
    }

    public String getWelcomeText() {
        return this.createButtonTitle;
    }

    public String getSignInButtonTitle() {
        return this.signInButtonTitle;
    }

    public String getSearchParam() {
        return this.searchParam;
    }

}
