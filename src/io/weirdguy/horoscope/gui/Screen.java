package io.weirdguy.horoscope.gui;

import io.weirdguy.horoscope.Logic;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * io.weirdguy.horoscope.gui by laiko in Horoscope_2
 * Created on 05.06.2017
 */
public class Screen extends JFrame {

    private JPanel rootPanel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JDatePickerImpl datePicker;
    private JButton doLogic;
    private JLabel yourPet;
    private JLabel horoscopePred;
    private JLabel daysAge;
    private JLabel imageZodiac;
    private ButtonGroup buttonGroup1;
    private Logic logic;
    private Screen f;

    public Screen() {
        super("Chinese horoscope");
        logic = new Logic();
        f = this;
        maleRadioButton.setActionCommand(maleRadioButton.getText());
        femaleRadioButton.setActionCommand(femaleRadioButton.getText());
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doLogic.addActionListener(e -> logic.handle(f));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUIComponents() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JLabel getYourPet() {
        return yourPet;
    }

    public JLabel getHoroscopePred() {
        return horoscopePred;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public JLabel getDaysAge() {
        return daysAge;
    }

    public JLabel getImageZodiac() {
        return imageZodiac;
    }
}
