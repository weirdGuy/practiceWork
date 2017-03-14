package io.weirdguy.tests;

import io.weirdguy.practice.FileWorker;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * io.weirdguy.tests by laiko in practiceWork
 * Created on 14.03.2017
 */
public class FileTester {

    static String dir;
    static File myFile;
    static File anotherFile;
    static File sortFile;
    static String[] lines1;
    static int[] lines2;
    static int[] lines3;

    @BeforeClass
    public static void initialSetUp() {
        dir = "E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\myString.txt";
        anotherFile = new File("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\secondTester.txt");
        sortFile = new File("E:\\Projects\\Practice\\practiceWork\\src\\io\\weirdguy\\sort.txt");
        myFile = new File(dir);
        lines1 = new String[]{"HelloWorld!0", "HelloWorldAgainb1", "HelloWorld!2", "HelloWorldAgaind3", "HelloWorld!4", "HelloWorldAgainf5", "HelloWorld!6", "HelloWorldAgainh7", "HelloWorld!8", "HelloWorldAgainj9"};
        lines2 = new int[]{0,1,2,3,4,5,6,7,8,9};
        lines3 = new int[]{1, 8, 2, 10, 10, 4, 12, 23};
    }

    @Test
    public void firstTester() {
        boolean one = true;
        String[] oneStr = FileWorker.readFile(myFile);
        for(int i = 0; i < oneStr.length; i++) {
            if(!oneStr[i].equals(lines1[i])) {
                one = false;
                break;
            }
        }
        assertTrue(one);
        System.out.println("First completed!");
    }

    @Test
    public void secondTester() {
        boolean two = true;
        FileWorker.writeToFile(lines1, anotherFile);
        String[] file = FileWorker.readFile(anotherFile);
        for(int i = 0; i < file.length; i++) {
            if(!file[i].equals(lines1[i])) {
                two = false;
                break;
            }
        }
        assertTrue(two);
        System.out.println("Second completed!");
    }

    @Test
    public void thirdTester() {
        assertTrue(FileWorker.isInFile("HelloWorld!0", myFile));
        System.out.println("Third completed!");
    }

    @Test
    public void fourthTester() {
        boolean fourth = true;
        FileWorker.SubstrInformation[] file = FileWorker.substrInFile("Hello", myFile);
        for(int i = 0; i < file.length; i++) {
            if(file[i].string != lines2[i]) {
                fourth = false;
                break;
            }
        }
        assertTrue(fourth);
        System.out.println("Fourth completed!");
    }

    @Test
    public void fifthTester() {
        boolean fifth = true;
        FileWorker.sortedFile(sortFile);
        String[] fileee = FileWorker.readFile(FileWorker.sortedFile(sortFile));
        for(int i = 0; i < fileee.length; i++) {
            if(fileee[i].length() != lines3[i]){
                fifth = false;
                break;
            }
        }
        assertTrue(fifth);
        System.out.println("Fifth completed!");
    }

}
