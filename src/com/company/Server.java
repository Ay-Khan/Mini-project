package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Server {
    public static Connection conn;

    public static void main(String args[]){
        try{
            ServerSocket server = new ServerSocket(1998);
            System.out.println("Waiting for client...");
            Socket socket = server.accept();
            System.out.println("Client connected");
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();


        }catch(Exception e){
            e.printStackTrace();
        }
    }






}
