package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


        public class Main{
            public static  MainFrame frame;
            public static Socket socket;
            public static ObjectOutputStream outStream;
            public static ObjectInputStream inputStream;
            public static ArrayList<Students> students;

            public static void main(String[] args) {

                try {
                    Socket socket = new Socket("127.0.0.1", 1998);
                    outStream = new ObjectOutputStream(socket.getOutputStream());
                    inputStream=new ObjectInputStream(socket.getInputStream());
            }catch (Exception e){
                    e.printStackTrace();
                }
                frame = new MainFrame();
                frame.setVisible(true);
            }

            public static void addStudent(Students sts){
                PackageData pd=new PackageData();
                pd.setOperationType("ADD");
                pd.setStudent(sts);

                try{
                    outStream.writeObject(pd);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            public static void getList(){
                PackageData pd=new PackageData();
                pd.setOperationType("LIST");

                try{
                   outStream.writeObject(pd);
                   pd=(PackageData)inputStream.readObject();
                   students=pd.getStudents();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }



        }

