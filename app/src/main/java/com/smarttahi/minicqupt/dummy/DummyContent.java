package com.smarttahi.minicqupt.dummy;

import com.smarttahi.minicqupt.Data.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    private static final List<Question> ITEMS = new ArrayList<Question>();

    /**
     * A map of sample (dummy) items, by ID.
     */

    private static final int COUNT = 6;


    public static void addItem(Question item) {
        ITEMS.add(item);
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}

