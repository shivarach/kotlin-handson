package org.shiva.kotlin.functional;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 4, 5};

        test(arr);


    }

    private static void test(int[] arr) {
        Arrays.stream(arr).map(x -> {
            System.out.println("shiva");
            return x * 2;
        }).forEach(y -> {
            System.out.println(y);
            return;
        });
        System.out.printf("out of test");
    }
}
