package com.cuprumz.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeUtils {

    public static void printNow() {
        System.out.println(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
                        .withZone(ZoneId.systemDefault())
                        .format(Instant.now()));
    }

    void printNow(int i) {
        // NOP
    }

    private void printNow(int i, int j) {
        // NOP
    }
}
