package com.franktan.animationblog.activitylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 */
public class ActivityEntryFactory {
    public static final List<ActivityEntry> ITEMS = new ArrayList<ActivityEntry>();

    private static final int COUNT = 25;

    static {
        addItem(createActivityEntryItem(1, "View Animation"));
        addItem(createActivityEntryItem(2, "Property Animation"));
        addItem(createActivityEntryItem(3, "Vector Animation"));
        addItem(createActivityEntryItem(4, "Recycler View Animation"));
    }

    private static void addItem(ActivityEntry item) {
        ITEMS.add(item);
    }

    private static ActivityEntry createActivityEntryItem(int position, String content) {
        return new ActivityEntry(String.valueOf(position), content);
    }

    /**
     * Activity Entry item representing an entry item in the list
     */
    public static class ActivityEntry {
        public final String id;
        public final String content;

        public ActivityEntry(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
