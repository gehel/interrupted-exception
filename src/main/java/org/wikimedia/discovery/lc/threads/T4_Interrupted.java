package org.wikimedia.discovery.lc.threads;

import java.util.Random;

public class T4_Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                // do stuff
            }
        });
        thread.start();

        Thread.sleep(1000L);

        thread.interrupt();
    }

}

/*
improvements:
  - actually works
  - let the thread control its shutdown cleanup
  - standardized: the same interrupted status can be checked in multiple pieces of code

limitations:
  - what happens when interruption happens deep in the call stack?
  - what happens if the thread is stuck in IO, sleep or synchronization?
*/
