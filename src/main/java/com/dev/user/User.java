package com.dev.user;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class User {
    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;

    public User(){
        try {
            this.socket = new Socket("localhost", 8080);
        }catch (IOException e){
            System.err.println("Socket failed");
        }
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            new ReadMsg(input).start();
            new WriteMsg(output).start();
        }catch (IOException e){
        }
    }

    public void user() {

        }
    }
