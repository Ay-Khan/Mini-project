package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPage extends Container {

    public AddPage() {
        setSize(500, 500);
        setLayout(null);

        JLabel lab1 = new JLabel("Name: ");
        lab1.setSize(300,30);
        lab1.setLocation(50,20);
        add(lab1);
        JLabel lab2 = new JLabel("Surname: ");
        lab2.setSize(300,30);
        lab2.setLocation(50,50);
        add(lab2);
        JLabel lab3 = new JLabel("Age:");
        lab3.setSize(300,30);
        lab3.setLocation(50,80);
        add(lab3);

        JTextField jTextField1 = new JTextField();
        jTextField1.setSize(300,30);
        jTextField1.setLocation(120,20);
        add(jTextField1);

        JTextField jTextField2 = new JTextField();
        jTextField2.setSize(300,30);
        jTextField2.setLocation(120,50);
        add(jTextField2);

        int allAge=100;
        Integer[] age = new Integer[allAge];
        int inc=1;
        for (int i=0;i<allAge;i++){
            age[i]=inc;
            inc++;
        }
        JComboBox<Integer> box = new JComboBox<>(age);
        box.setSize(300,30);
        box.setLocation(120,80);
        add(box);


        JButton btn1=new JButton("ADD");
        btn1.setSize(120,30);
        btn1.setLocation(80,170);
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students student=new Students();
                String name=jTextField1.getText();
                String surname=jTextField2.getText();
                Integer age=box.getSelectedIndex();

                student.setName(name);
                student.setSurname(surname);
                student.setAge(age);
                Main.addStudent(student);



            }
        });

        JButton btn2=new JButton("BACK");
        btn2.setSize(120,30);
        btn2.setLocation(250,170);
        add(btn2);

        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Main.frame.showFirstPage();
            }
        });



    }
}
