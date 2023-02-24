package ch2;

public interface LanguageService {
    String hello();

    static LanguageService of(String lang) {
        if(lang.equals("ko")) return new KoreanLanguageService();
        else return new FrenchLanguageService();
    }
}
