package info.miki.znacenjePrezimena.data;

import java.util.ArrayList;
import java.util.List;

import info.miki.znacenjePrezimena.R;


public class BookAssets {

    private static final List<Integer> books = new ArrayList<Integer>() {{
        add(R.drawable.a1);
        add(R.drawable.a2);
        add(R.drawable.a3);
        add(R.drawable.a4);
        add(R.drawable.a5);
        add(R.drawable.a6);
        add(R.drawable.a7);
        add(R.drawable.a8);
        add(R.drawable.a9);
        add(R.drawable.a10);
        add(R.drawable.a11);
        add(R.drawable.a12);
        add(R.drawable.a13);
    }};


    public static List<Integer> getBooks() {
        return books;
    }
}
