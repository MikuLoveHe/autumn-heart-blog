package com.mikulovehe.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class nowTime {

    public static String getTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }
}
