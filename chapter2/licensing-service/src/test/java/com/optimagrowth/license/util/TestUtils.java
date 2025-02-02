package com.optimagrowth.license.util;

public class TestUtils {
    public static void printSectionHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));
    }

    public static void printDivider() {
        System.out.println("-".repeat(50));
    }
}