package ch2.di;

import java.util.List;

public class SpellCheckerSingleton {

    private static final DictionarySample DICTIONARY_SAMPLE = new DictionarySample();

    private SpellCheckerSingleton() {};
    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public boolean isValid(String word) { return true; }

    public List<String> suggestions(String typo) { return null; }
}
