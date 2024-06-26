package org.wikimedia.discovery.lc.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

public class T7_InterruptedIO {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                doIO();
            }
        });
        thread.start();

        Thread.sleep(1000L);

        thread.interrupt();
    }

    private static void doIO() {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        try {

            if (buffer.ready())
                // readLine() will block indefinitely if no input
                buffer.read();

        } catch (InterruptedIOException ignore) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

/*
improvements:
  - IO is protected

limitations:
  - any blocking call needs to be treated with special attention
*/
