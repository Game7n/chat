package com.dev.user;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class User {
    public void user() {
        try(Socket socket = new Socket("localhost",8080);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        ){

            String massage = "Nikita";

            output.write(massage + "\n");
            output.flush();

            System.out.println(input.readLine());


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
