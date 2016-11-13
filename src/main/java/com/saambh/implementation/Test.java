package com.saambh.implementation;

import java.util.Scanner;

/**
 * Created by ajamwal on 11/13/16.
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();

        int appleS = s - a;
        int appleE = t - a;
        int appleC = 0;
        for (int apple_i = 0; apple_i < m; apple_i++) {
            int thisApple = in.nextInt();
            if (appleS <= thisApple && thisApple <= appleE) {
                appleC++;
            }
        }

        int orangeS = s - b;
        int orangeE = t - b;
        int orangeC = 0;
        for (int orange_i = 0; orange_i < n; orange_i++) {
            int thisOrange = in.nextInt();
            if (orangeS <= thisOrange && thisOrange <= orangeE) {
                orangeC++;
            }
        }
        System.out.println(appleC);
        System.out.println(orangeC);
    }
}
