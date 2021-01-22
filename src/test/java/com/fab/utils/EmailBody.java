package com.fab.utils;

import java.util.ArrayList;

public class EmailBody {
    private static StringBuilder content;
    private static EmailBody instance = null;
    private static boolean testFailed = false;

    private EmailBody() {
        content = new StringBuilder();
    }

    public static void reset() {
        instance = new EmailBody();
        testFailed = false;
    }

    public static void addLine(String line) {
        content.append(line);
        content.append("\n");
    }

    public static void addLines(ArrayList<String> lines) {
        for (String line : lines)
            addLine(line);
    }

    public static String getBody() {
        return content.toString();
    }

    public static void testFailed() {
        testFailed = true;
    }

    public static boolean getTestFailed() {
        return testFailed;
    }
}
