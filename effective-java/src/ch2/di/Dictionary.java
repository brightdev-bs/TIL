package ch2.di;

import java.util.List;

public interface Dictionary {

    boolean isValid(String word);
    List<String> suggestions(String type);
}
