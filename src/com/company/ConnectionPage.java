package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ConnectionPage extends Container {

        public ConnectionPage() {

            setSize(500, 500);
            setLayout(null);

            JButton btn1 = new JButton("Add students");
            btn1.setSize(300, 30);
            btn1.setLocation(100, 100);

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Main.frame.showSecondPage();
                }
            });
            add(btn1);

            JButton btn2 = new JButton("List of students");
            btn2.setSize(300, 30);
            btn2.setLocation(100, 150);
            add(btn2);


            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.showThirdPage();

                }
            });

            JButton btn3 = new JButton("Exit");
            btn3.setSize(300, 30);
            btn3.setLocation(100, 200);
            add(btn3);

            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);

                }
            });
        }

}
