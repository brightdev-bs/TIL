package ch2.di;

import java.util.List;

public class SpellCheckerStatic {

    private static final DictionarySample DICTIONARY_SAMPLE = new DictionarySample();

    private SpellCheckerStatic() {}

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggestions(String type) {
        return null;
    }

}
