package com.dev.user;

import java.io.BufferedWriter;
import java.io.IOException;

public class WriteMsg extends Thread{

    private BufferedWriter output;

    public WriteMsg(BufferedWriter output) {
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String userWorld = "Nikita";

                output.write(userWorld);
                output.flush();
            }catch (IOException e){

            }
        }
    }
}
