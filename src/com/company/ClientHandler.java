package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler extends Thread{
    private Socket socket;
    public static Connection conn;
    public static PackageData pd;
    public static ObjectInputStream inputStream;
    public static ObjectOutputStream outputStream;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run(){

        Scanner in=new Scanner(System.in);
        try{
            connectToDb();
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            pd =new PackageData();
            while((pd=(PackageData)inputStream.readObject())!=null ){
                if(pd.getOperationType().equals("ADD")){
                    System.out.println(pd.getStudent().toString());
                    addStudentToDb(pd.getStudent());
                }else if(pd.getOperationType().equals("LIST")) {
                    pd.setStudents(getStudents());
                    try {
                        outputStream.writeObject(pd);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getStudents() {
        ArrayList<Students> studentsList = new ArrayList<>();
        try {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `students`");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    int age = resultSet.getInt("age");
                    studentsList.add(new Students(id, name, surname, age));
                }
                preparedStatement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return studentsList;
        }


    public static void addStudentToDb(Students student){
        try{
            Statement st = conn.createStatement();
            PreparedStatement statement=conn.prepareStatement(""+"INSERT INTO students(id,name,surname,age)" + "VALUES(NULL,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setInt(3,student.getAge());
            int row=statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void connectToDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useUnicode=true&serverTimezone=UTC","root","");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
