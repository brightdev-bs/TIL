package ch2.staticfactorymethod;

public class LanguageMain {

    public static void main(String[] args) {
        LanguageService languageService = new KoreanLanguageService();
        System.out.println(languageService.hello());

        LanguageService languageService2 = LanguageService.of("ko");
        System.out.println(languageService2.hello());
    }
}
