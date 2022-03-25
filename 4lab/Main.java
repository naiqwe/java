package com.company;

import java.io.*;
import java.util.*;


public class Main  {
    private static Scanner in = new Scanner(System.in);
    private static String exit = "exit";
    private static String menu = "1-Сборник Анекдотов 2-Сборник цитат 3-Вывод 4-Stream 0=Выход";

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
                        sbornikAnekdotov();
                        break;
                    }
                    case '2': {
                        sbornikCitat();
                        break;
                    }
                    case '3': {
                        output();
                        break;
                    }
                    case '4': {
                        test();
                        break;
                    }
                    case '0': {
                        System.out.println("Done");
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



    private static void sbornikAnekdotov() throws WrongParException {
        System.out.println("Введите данные анекдота (Количетсво пргф, Название, Количество вводных пргф, автор)");
        System.out.println("exit - чтобы выйти");

        int paragraphCount;
        String name;
        int intrparagraphCount;
        List<String> author = new LinkedList<String>();

        String line = in.nextLine();
        if (!exit.equals(line)) {
            paragraphCount = Integer.parseInt(line);
        } else {
            System.out.println("Aborted");
            return;
        }


        line = in.nextLine();
        if (!exit.equals(line)) {
            name = line;
        } else {
            System.out.println("Aborted");
            return;
        }

        line = in.nextLine();
        if (!exit.equals(line)) {
            intrparagraphCount = Integer.parseInt(line);
        } else {
            System.out.println("Aborted");
            return;
        }

        line = in.nextLine();
        while (!exit.equals(line)) {
            author.add(line);
            line = in.nextLine();
        }

        collections.add(new SbornikAnekdotov(paragraphCount, name, intrparagraphCount, author));
        System.out.println("Анекдот добавлен");
        return;
    }

    private static void sbornikCitat() throws WrongParException {
        System.out.println("Введите данные цитаты (Количетсво пргф, Название, Количество вводных пргф, автор)");
        System.out.println("exit - чтобы выйти");

        int paragraphCount;
        String name;
        int intrparagraphCount;
        List<String> author = new LinkedList<String>();

        String line = in.nextLine();
        if (!exit.equals(line)) {
            paragraphCount = Integer.parseInt(line);
        } else {
            System.out.println("Aborted");
            return;
        }


        line = in.nextLine();
        if (!exit.equals(line)) {
            name = line;
        } else {
            System.out.println("Aborted");
            return;
        }

        line = in.nextLine();
        if (!exit.equals(line)) {
            intrparagraphCount = Integer.parseInt(line);
        } else {
            System.out.println("Отмена");
            return;
        }

        line = in.nextLine();
        while (!exit.equals(line)) {
            author.add(line);
            line = in.nextLine();
        }

        collections.add(new SbornikCitat(paragraphCount, name, intrparagraphCount, author));
        System.out.println("Цитата добавлена");
        return;
    }

    private static void output() {
        for (GetSet col : collections) {
            System.out.println(col);
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

        var sbornikCitat = new LinkedList<SbornikCitat>();
        var sbornikAnekdotov = new LinkedList<SbornikAnekdotov>();
        for (GetSet col : collections) {
            if (col instanceof SbornikCitat) {
                sbornikCitat.add((SbornikCitat) col);
                continue;
            }

            else if (col instanceof SbornikAnekdotov) {
                sbornikAnekdotov.add((SbornikAnekdotov) col);
                continue;
            }
        }


    }








    private static void test() throws IOException, ClassNotFoundException {
        if (collections.isEmpty()) {
            throw new RuntimeException("empty");
        }

        GetSet fromInst;
        GetSet toInst;

        OutputStream outputStream;
        InputStream inputStream;

        Writer writer;
        Reader reader;

        fromInst = collections.get(0);


        System.out.println("read/write");
        writer = new CharArrayWriter();
        Stream.write(fromInst, writer);
        reader = new CharArrayReader(((CharArrayWriter) writer).toCharArray());
        toInst = Stream.read(reader);
        System.out.println(fromInst.equals(toInst));


        System.out.println("input/output");
        outputStream = new ByteArrayOutputStream();
        Stream.output(fromInst, outputStream);
        inputStream = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
        toInst = Stream.input(inputStream);
        System.out.println(fromInst.equals(toInst));


        System.out.println("serialize/deserialize");
        outputStream = new ByteArrayOutputStream();
        Stream.serialize(fromInst, outputStream);
        inputStream = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
        toInst = Stream.deserialize(inputStream);
        System.out.println(fromInst.equals(toInst));


    }





/*    private static ArrayList<String> author = new ArrayList<String>();
    private static ArrayList<String> author2 = new ArrayList<String>();
    private static ArrayList<String> author3 = new ArrayList<String>();
    private static ArrayList<String> author4 = new ArrayList<String>();*/

   /* public static void main(String[] args) throws IOException, ClassNotFoundException {


        var sbornikCitat1 = new SbornikCitat();
        var sbornikCitat2 = new SbornikCitat();

        var sbornikAnekdotov1 = new SbornikAnekdotov();
        var sbornikAnekdotov2 = new SbornikAnekdotov();

        try {
   sbornikCitat1.setParagraphСount(5);
    sbornikCitat1.setName("Citata#1");
    sbornikCitat1.setIntrParphCount(2);
    author.add("Alekseev");
    sbornikCitat1.setAuthor(author);
    collections.add(sbornikCitat1);


    sbornikCitat2.setParagraphСount(7);
    sbornikCitat2.setName("Citata#2");
    sbornikCitat2.setIntrParphCount(3);
    sbornikCitat2.setAuthor(author2);
    author2.add("Antonov");
    collections.add(sbornikCitat2);

    sbornikAnekdotov1.setParagraphСount(9);
    sbornikAnekdotov1.setName("Anekdot#1");
    sbornikAnekdotov1.setIntrParphCount(2);
    author3.add("Sergeev");
    sbornikAnekdotov1.setAuthor(author3);
    collections.add(sbornikAnekdotov1);

    sbornikAnekdotov2.setParagraphСount(4);
    sbornikAnekdotov2.setName("Anekdot#2");
    sbornikAnekdotov2.setIntrParphCount(4);
    sbornikAnekdotov2.setAuthor(author4);
    author4.add("Petrov");
    collections.add(sbornikAnekdotov2);
        }

catch (WrongParException ex)
{
    System.err.println(ex.getMessage());
}


        System.out.println(collections.get(0).paragraphCountWithoutIntr(0));

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


        System.out.println("Test:");
       test();
    }*/




}