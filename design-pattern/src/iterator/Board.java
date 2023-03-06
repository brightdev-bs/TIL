package iterator;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<String> titles;

    public Board() {
        titles = new ArrayList<>();
    }

    public void addTitle(String title) {
        titles.add(title);
    }

    public List<String> getTitles() {
        return titles;
    }
}
