package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.nio.*;
import java.text.ParseException;
import java.util.*;

public class Stream   {


    private static GetSetFactory factory = new SbornikAnekdotovFactory();

    public static void setFactory(GetSetFactory fac) {
        factory = fac;
    }

    public static GetSet createInstance() {
        return factory.createInstance();
    }

    public static GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) throws Exception {
        return factory.createInstance(paragraphСount, name, intrParphCount, author);
    }


    public static void output(GetSet inst, OutputStream out) {
        try {
            out.write(inst.getName().getBytes());
            out.write('\0');
            out.write(ByteBuffer.allocate(4).putInt(inst.getIntrParphCount()).array());
            out.write('\0');
            out.write(ByteBuffer.allocate(4).putInt(inst.getParagraphСount()).array());
            out.write('\0');


            for (String str : inst.getAuthor()) {
                out.write(str.getBytes());
                out.write('\0');
            }
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }



    public static GetSet input(InputStream in) {
        try {
            var arr = new ByteArrayOutputStream();
            var author = new LinkedList<String>();

            int tmp;
            while ((tmp = in.read()) != -1) {
                if (tmp != '\0') {
                    arr.write(tmp);
                } else {
                    break;
                }
            }

            var name = arr.toString();
            arr.reset();


            var intrParphCount = ByteBuffer
                    .wrap(new byte[] { (byte) in.read(), (byte) in.read(), (byte) in.read(), (byte) in.read() }).getInt();

            in.read();

            var ParphCount = ByteBuffer
                    .wrap(new byte[] { (byte) in.read(), (byte) in.read(), (byte) in.read(), (byte) in.read() }).getInt();

            in.read();

            while ((tmp = in.read()) != -1) {
                if (tmp != '\0') {
                    arr.write(tmp);
                } else {

                    author.add(arr.toString());
                    arr.reset();
                }
            }

            if (arr.size() != 0) {
                author.add(arr.toString());
            }





            return createInstance(ParphCount, name, intrParphCount, author);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void write(GetSet inst, Writer out) {
        try {
            out.append(inst.getName());
            out.append(' ');
            out.append(String.valueOf(inst.getIntrParphCount()));
            out.append(' ');
            out.append(String.valueOf(inst.getParagraphСount()));

            for (String str : inst.getAuthor()) {
                out.append(' ');
                out.append(str);
            }
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }



    public static GetSet read(Reader in) {
        try {
            var buf = new BufferedReader(in);
            var arr = new StringBuilder();
            var author = new ArrayList<String>();

            int tmp;
            while ((tmp = buf.read()) != -1) {
                if (tmp != ' ') {
                    arr.append((char) tmp);
                } else {
                    break;
                }
            }

            var name = arr.toString();
            arr.setLength(0);

            while ((tmp = buf.read()) != -1) {
                if (tmp != ' ') {
                    arr.append((char) tmp);
                } else {
                    break;
                }
            }



            var intrParphCount = Integer.parseInt(arr.toString());


            var paragraphСount = Integer.parseInt(arr.toString());

            arr.setLength(0);

            while ((tmp = buf.read()) != -1) {
                if (tmp != ' ') {
                    arr.append((char) tmp);
                } else {
                    author.add(arr.toString());
                    arr.setLength(0);
                }
            }

            if (arr.length() != 0) {
                author.add(arr.toString());
            }






            return createInstance(paragraphСount, name, intrParphCount, author);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }


    public static void serialize(GetSet o, OutputStream out) throws IOException {
        new ObjectOutputStream(out).writeObject(o);
    }

    public static GetSet deserialize(InputStream in) throws IOException, ClassNotFoundException {
        return (GetSet) new ObjectInputStream(in).readObject();
    }



}