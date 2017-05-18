package io.weirdguy.practice;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double range = 6.30;
        double step = 0.05;

        System.out.print("Enter range of graphics: ");
        range = input.nextDouble();

        System.out.print("Enter step of graphics: ");
        step = input.nextDouble();


        GraphWindow frame = new GraphWindow(range, step);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();

    }
}
