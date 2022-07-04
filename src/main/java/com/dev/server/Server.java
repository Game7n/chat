package com.dev.server;

import com.dev.thread.ServerSomthing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Server extends Thread {

    public static LinkedList<ServerSomthing> serverList = new LinkedList<ServerSomthing>();


    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            System.out.println("server works");

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("new user");

                serverList.add(new ServerSomthing(socket));

                //HandleRequest(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void HandleRequest(Socket socket) {
        try(
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                ){

            String massage = input.readLine();
            System.out.println(massage);

            output.write("Hallo " + massage);
            output.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
