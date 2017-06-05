package io.weirdguy.horoscope;

import io.weirdguy.horoscope.gui.Screen;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * io.weirdguy.horoscope by laiko in Horoscope_2
 * Created on 05.06.2017
 */
public class Logic {

    public String[] animals = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat"};
    public String[] maleFeel = {"Purposefulness", "Leadership", "Courage", "Honesty", "Freedom", "Artistry", "Individualism"};
    public String[] femaleFeel = {"Impulsiveness", "Tenderness", "Passion", "Скромність", "Enthusiasm", "Romance", "Mystique"};
    private Screen frame;

    public void handle(Screen frame) {
        this.frame = frame;
        try {
            countAnimal();
            countFeeling();
            countDays();
        } catch (Exception e) {
            frame.getYourPet().setText("");
            frame.getHoroscopePred().setText("");
            frame.getDaysAge().setText("");
            frame.getImageZodiac().setIcon(null);
            JOptionPane.showMessageDialog(null, "Specify sex and/or birthday params", "Ooops, something wrong", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void countDays() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(frame.getDatePicker().getModel().getYear(), frame.getDatePicker().getModel().getMonth(), frame.getDatePicker().getModel().getDay());

        frame.getDaysAge().setText("" + (Math.abs((int)( (cal1.getTime().getTime() - cal2.getTime().getTime()) / (1000 * 60 * 60 * 24)))+1));
    }

    private void countFeeling() {
        LocalDate date = LocalDate.of(frame.getDatePicker().getModel().getYear(),
                frame.getDatePicker().getModel().getMonth()+1,
                frame.getDatePicker().getModel().getDay());
        if(frame.getButtonGroup1().getSelection().getActionCommand() == "Male") {
            frame.getHoroscopePred().setText(maleFeel[date.getDayOfWeek().getValue() % 7]);
        } else if(frame.getButtonGroup1().getSelection().getActionCommand() == "Female") {
            frame.getHoroscopePred().setText(femaleFeel[date.getDayOfWeek().getValue() % 7]);
        }

    }

    private void countAnimal() {
        frame.getYourPet().setText(animals[frame.getDatePicker().getModel().getYear() % 12]);
        frame.getImageZodiac().setIcon(new ImageIcon("E:\\Projects\\Horoscope_2\\img\\" + animals[frame.getDatePicker().getModel().getYear() % 12] + ".png"));
    }

    public void log(Object o) {
        System.out.println(o);
    }

}
