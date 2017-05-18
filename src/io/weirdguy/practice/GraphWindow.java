package io.weirdguy.practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;

/**
 * io.weirdguy.practice by laiko in GrapichWork
 * Created on 17.05.2017
 */
public class GraphWindow extends JFrame {

    private double radius = 1;
    private double range = 6.3;
    private double step = 0.05;
    private double x = 0;
    private double y = 0;
    private double size;
    private JButton button;
    private JPanel panel;

    public GraphWindow(double range, double step) {
        super("My Graphics");
        this.size = 50;
        this.range = range;
        this.step = step;
        setSize(600, 600);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button = new JButton("Save image");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });

        panel = new JPanel();
        panel.setLayout(null);
        button.setBounds(10, 10, 100, 30);

        panel.add(button);
        add(panel);
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                size += e.getWheelRotation();
                repaint();
            }
        });

    }

    public void paint(Graphics g) {
        button.repaint();
        resetVal();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D graphics = (Graphics2D) g;
        g.setColor(Color.black);


        drawMarkup(g);

        for(double i = step; i <= range; i = i + step) {
            x = radius * Math.pow(Math.cos(i), 3);
            y = radius * Math.pow(Math.sin(i), 3);
            graphics.draw(new Line2D.Double((this.getWidth() / 2) + radius * Math.pow(Math.cos(i - step), 3) * size, (this.getHeight() / 2) + radius * Math.pow(Math.sin(i - step), 3) * size * (-1), (this.getWidth() / 2) + x * size, (this.getHeight() / 2) + y * size * (-1)));
        }
    }

    public void saveImage(){
        try
        {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            paint(graphics2D);
            String path = getFilePath();
            ImageIO.write(image,"jpeg", new File(path));
            JOptionPane.showMessageDialog(null, "Image saved to:\n" + path, "My Graphics", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog(null, "Unable to save image", "My Graphics", JOptionPane.ERROR_MESSAGE);
            System.out.println("Cannot save image");
        }
    }

    private String getFilePath() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("title");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG images", "jpeg");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showOpenDialog(this);
        if (!chooser.getSelectedFile().toString().endsWith(".jpeg"))
            return chooser.getSelectedFile().getPath() + ".jpeg";

        return chooser.getSelectedFile().getPath();
    }

    private void resetVal() {
        this.x = 0;
        this.y = 0;
    }

    private void drawMarkup(Graphics g){

        g.drawLine(0,this.getHeight() / 2,this.getWidth(),this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0,this.getWidth() / 2, this.getHeight());

        g.drawString("0", (int) (this.getWidth() / 2),(int) this.getHeight() / 2 + 20);

        for(int i = 1; i < this.getWidth() / size / 2; i++) {
            g.drawLine((int) ((this.getWidth() / 2) - (i * size)), this.getHeight() / 2 - 10, (int) ((this.getWidth() / 2) - (i * size)), this.getHeight() / 2 + 10);
            g.drawLine((int) ((this.getWidth() / 2) + (i * size)), this.getHeight() / 2 - 10, (int) ((this.getWidth() / 2) + (i * size)), this.getHeight() / 2 + 10);
            g.drawLine(this.getWidth() / 2 - 10, (int) ((this.getHeight() / 2) - (i * size)), this.getWidth() / 2 + 10, (int) ((this.getHeight() / 2) - (i * size)));
            g.drawLine(this.getWidth() / 2 - 10, (int) ((this.getHeight() / 2) + (i * size)), this.getWidth() / 2 + 10, (int) ((this.getHeight() / 2) + (i * size)));

            g.drawString("" + i * (-1), ((this.getWidth() / 2) + 20),(int) ((this.getHeight() / 2)  - (i * size)));
            g.drawString("" + i, ((this.getWidth() / 2) + 20),(int) ((this.getHeight() / 2)  + (i * size)));
            g.drawString("" + i * (-1), (int) ((this.getWidth() / 2) - (i * size)),this.getHeight() / 2 + 20);
            g.drawString("" + i, (int) ((this.getWidth() / 2) + (i * size)),this.getHeight() / 2 + 20);
        }
    }

}
