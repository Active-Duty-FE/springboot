package com.msb.api.common;

public class SystemUtils {
    public static boolean isNull(Object obj) {
        return obj == null;
    }
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
