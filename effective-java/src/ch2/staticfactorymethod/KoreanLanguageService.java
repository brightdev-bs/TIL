package ch2.staticfactorymethod;

public class KoreanLanguageService implements LanguageService {

    @Override
    public String hello() {
        return "안녕하세요";
    }
}
