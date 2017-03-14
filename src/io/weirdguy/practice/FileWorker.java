package io.weirdguy.practice;

import io.weirdguy.homework6.ClassForWorkingWithFile;
import ua.princeton.lib.In;

import java.io.*;
import java.util.ArrayList;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 14.03.2017
 */
public class FileWorker {

    public static String[] readFile(File input) {
        In in = new In(input);
        String[] str = in.readAllStrings();

        return str;
    }

    public static void writeToFile(String[] input, File file) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (int i = 0; i < input.length; i++) out.write(input[i]+"\n");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isInFile(String input, File file) {
        String[] strArr = readFile(file);
        for (int i = 0; i < strArr.length; i++)
            if(input.equals(strArr[i]))
                return true;

        return false;
    }

    public static SubstrInformation[] substrInFile(String input, File file) {
        int length = 0;
        String [] strArr = readFile(file);
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0, k = input.length(); strArr[i].length() >= input.length() &&
                    j <= strArr[i].length() - input.length(); j++,k++) {
                if(strArr[i].substring(j,k).equals(input)) {
                    if(j>length)
                        length = j+1;
                    else
                        length++;
                }
            }
        }
        SubstrInformation[] resArr = new SubstrInformation[strArr.length];
        int [][] arr = new int[strArr.length][length];
        for (int i = 0; i < strArr.length; i++) for (int j = 0; j < length; j++) arr[i][j] = -1;

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0, k = input.length(); strArr[i].length() >= input.length() &&
                    j <= strArr[i].length() - input.length(); j++,k++) {
                if(strArr[i].substring(j,k).equals(input)) {
                    arr[i][j] = j;
                }
            }
            resArr[i] = new SubstrInformation(i,arr[i]);
        }

        return resArr;
    }

    public static File sortedFile(File file) {
        String dir = "E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\sortedAsc" + file.getName();
        File fileWrite = new File(dir);
        String [] arr = readFile(file);
        sortStr(arr);
        writeToFile(arr, fileWrite);
        return fileWrite;
    }

    private static void sortStr(String[] a) {
        int n = a.length;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    exch(a, i, i + 1);
                    swap = true;
                }
            }
        }
    }

    private static void exch(String[] a, int i, int j){
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void replaceStr(String str, String orig, String repl) throws IOException{
        File input = new File("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\" + str);
        if(isInFile(orig, input)) {
            File newFile = new File("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\" + "repl_str_" + str);
            writeToFile(readFile(input), newFile);
            int index;
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader fReader = new BufferedReader(new FileReader("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\" + "repl_str_" + str));
            for (int i = 0; true; i++) {
                String s;
                s = fReader.readLine();
                if (s == null)
                    break;
                index = s.indexOf(orig);
                if (index != -1)
                    s = s.substring(0, index) + repl + s.substring(index + orig.length());
                list.add(i, s);
            }
            fReader.close();
            change("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\" + "repl_str_" + str, list);
        }
        else return;
    }

    private static void change(String str, ArrayList<String> list) throws IOException{
        PrintWriter fileWriter = new PrintWriter(new FileWriter(str,false));
        PrintWriter fileWriterTrue = new PrintWriter(new FileWriter(str,true));
        fileWriter.print("");
        String s;
        for(int i = 0; i < list.size(); i++){
            s = list.get(i);
            System.out.println(s);
            fileWriterTrue.println(s);
        }
        fileWriter.close();
        fileWriterTrue.close();
    }

    public static class SubstrInformation{
        public int string;
        public int[] firstChar;

        public SubstrInformation(int string, int [] firstChar){
            this.string = string;
            this.firstChar = firstChar;
        }
    }
}
