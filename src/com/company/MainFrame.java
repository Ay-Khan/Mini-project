package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
    public  ConnectionPage first;
    public  AddPage second;
    public  InteractionPage third;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mini project");
        setSize(500,500);
        setLayout(null);

        first = new ConnectionPage();
        first.setLocation(0,0);
        add(first);

        second = new AddPage();
        second.setLocation(0,0);
        second.setVisible(false);
        add(second);

        third = new InteractionPage();
        third.setLocation(0,0);
        third.setVisible(false);
        add(third);

    }
    public void showThirdPage(){
        first.setVisible(false);
        second.setVisible(false);
        third.setVisible(true);
    }

    public void showSecondPage(){
        first.setVisible(false);
        second.setVisible(true);
        third.setVisible(false);
    }

    public void showFirstPage(){
        second.setVisible(false);
        third.setVisible(false);
        first.setVisible(true);

    }
}
