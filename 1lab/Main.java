package com.company;

public class Main {

    public static void main(String[] args) {
        var o = new second(0, 0);
        int i, j;
        for (i = 1; i <= 8; i++) {
            for (j = 1; j <= 8; j++) {
                o.setA(i);
                o.setB(j);
                System.out.print(o.Sum());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
