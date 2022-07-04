package com.dev.user;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadMsg extends Thread {

    private BufferedReader input;

    public ReadMsg(BufferedReader input) {
        this.input = input;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String str = input.readLine();
            }
        } catch (IOException e) {

        }
    }

}
