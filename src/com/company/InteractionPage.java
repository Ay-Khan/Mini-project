package com.company;

import com.sun.jndi.ldap.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InteractionPage extends Container {
    public ArrayList<Students> studentlist;
    private TextArea textArea;



    public InteractionPage() {
        try {
            setSize(500, 500);
            setLayout(null);

            JLabel lab1 = new JLabel("LIST OF STUDENTS ");
            lab1.setSize(300, 30);
            lab1.setLocation(100, 20);
            add(lab1);

            textArea = new TextArea();
            textArea.setSize(150, 150);
            textArea.setLocation(100, 100);

            add(textArea);

            JButton btn1 = new JButton("LIST");
            btn1.setSize(120, 30);
            btn1.setLocation(120, 60);
            add(btn1);
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Main.getList();
                    Main.frame.third.UpdateTArea();


                }
            });

            JButton btn2 = new JButton("BACK");
            btn2.setSize(120, 30);
            btn2.setLocation(270, 60);
            add(btn2);

            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Main.frame.showFirstPage();
                }
            });


            } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void UpdateTArea() {
        studentlist=Main.students;
        for (int i = 0; i<studentlist.size(); i++) {
            textArea.append(studentlist.get(i).toString()+"\n");
        }
    }

    }

