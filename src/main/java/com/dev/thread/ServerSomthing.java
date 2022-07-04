package com.dev.thread;

import com.dev.server.Server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerSomthing extends Thread{

    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;

    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;

        input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        start();
    }

    @Override
    public void run() {
        String word;
        try {

            while (true) {
                word = input.readLine();
                for (ServerSomthing vr : Server.serverList) {
                    vr.send(word);
                }
            }

        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try {
            output.write(msg + "\n");
            output.flush();

        } catch (IOException ignored) {}
    }


}
