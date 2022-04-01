package com.company;

import java.io.*;
import java.util.*;


public class Main  {
    private static Scanner in = new Scanner(System.in);
    private static String exit = "exit";
    private static String menu = "1-task1 2-task2 3-task3 0-exit";

    private static Scanner scan = new Scanner(System.in);
    private static LinkedList<GetSet> collections = new LinkedList<GetSet>();
    private static String name = "";
    private static int intrParphCount = 0;

    public static void main(String[] args) {
        menu();
    }


    private static void menu() {
        char ch;
        do {
            try {
                System.out.println(menu);
                ch = in.nextLine().charAt(0);

                switch (ch) {
                    case '1': {
                        task1();
                        break;
                    }
                      case '2': {
                          task2();
                        break;
                    }
                    case '3': {
                        task3();
                        break;
                    }
                    case '0': {

                        System.exit(0);
                        return;
                    }
                }
            } catch (Exception exc) {
                exc.printStackTrace();
                System.exit(1);
                return;
            }
        } while (ch != '0');
    }


    private static void task1() throws InterruptedException {
        var arr = new GetSetS();
        var writer = new ThreadWrite(arr);
        var reader = new ThreadRead(arr);

        writer.setPriority(1);
        writer.start();

        reader.setPriority(10);
        reader.start();

    }

    private static void task2() {
        var arr = new GetSetS();
        var sync = new GetSetSync(arr);

        var writer = new ThreadWriteSync(sync);
        var reader = new ThreadReadSync(sync);

        var writerThread = new Thread(writer);
        var readerThread = new Thread(reader);

        writerThread.start();
        readerThread.start();
    }

    private static void task3() {
        var getsets = new GetSetS();
        var sync = GetSetM.SynchronizedGetSet(getsets);

        var setOneThread = new Thread(() -> {
            var arr = sync.getArray();
            arr[0] = 1;
            System.out.println("setOneThread");
        });

        var setTwoThread = new Thread(() -> {
            var arr = sync.getArray();
            arr[0] = 2;
            System.out.println("setTwoThread");
        });

        var readThread = new Thread(() -> {
            var arr = sync.getArray();
            System.out.println("Read: " + arr[0]);
        });

        setOneThread.start();
        readThread.start();
        setTwoThread.start();
    }

































}