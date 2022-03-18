package com.company;

import java.util.*;


public class Main {
    private static LinkedList<GetSet> collections = new LinkedList<GetSet>();
    private static String name = "";
    private static int intrParphCount = 0;
    private static ArrayList<Integer> paragraphCount = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount2 = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount3 = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount4 = new ArrayList<Integer>();

    public static void main(String[] args){


        var sbornikCitat1 = new SbornikCitat();
        var sbornikCitat2 = new SbornikCitat();
        var sbornikAnekdotov1 = new SbornikAnekdotov();
        var sbornikAnekdotov2 = new SbornikAnekdotov();

        try {
    sbornikCitat1.setParagraphСount(paragraphCount);
    paragraphCount.add(10);
    sbornikCitat1.setName("Citata#1");
    sbornikCitat1.setIntrParphCount(1);
    collections.add(sbornikCitat1);


    sbornikCitat2.setParagraphСount(paragraphCount2);
    paragraphCount2.add(15);
    sbornikCitat2.setName("Citata#2");
    sbornikCitat2.setIntrParphCount(3);
    collections.add(sbornikCitat2);

    sbornikAnekdotov1.setParagraphСount(paragraphCount3);
    paragraphCount3.add(25);
    sbornikAnekdotov1.setName("Anekdot#1");
    sbornikAnekdotov1.setIntrParphCount(2);
    collections.add(sbornikAnekdotov1);

    sbornikAnekdotov2.setParagraphСount(paragraphCount4);
    paragraphCount4.add(12);
    sbornikAnekdotov2.setName("Anekdot#2");
    sbornikAnekdotov2.setIntrParphCount(4);
    collections.add(sbornikAnekdotov2);
        }

catch (WrongParException ex)
{
    System.err.println(ex.getMessage());
}

        var map = new HashMap<Integer, LinkedList<GetSet>>();
        int key;
        for (GetSet col : collections) {
            key = col.paragraphCountWithoutIntr(0);
            if (map.containsKey(key)) {
                map.get(key).add(col);
            } else {
                var list = new LinkedList<GetSet>();
                list.add(col);
                map.put(key, list);
            }
        }

        System.out.println("map");
        System.out.println(map);

       var sbornikCitat = new LinkedList<SbornikCitat>();
        var sbornikAnekdotov = new LinkedList<SbornikAnekdotov>();
        for (GetSet col : collections) {
            if (col instanceof SbornikCitat) {
                sbornikCitat.add((SbornikCitat) col);
            }

            else if (col instanceof SbornikAnekdotov) {
                sbornikAnekdotov.add((SbornikAnekdotov) col);
            }
    }

        System.out.println("sbornikCitat");
        System.out.println(sbornikCitat);
        System.out.println("sbornikAnekdotov");
        System.out.println(sbornikAnekdotov);
    }
}