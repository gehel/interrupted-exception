package org.wikimedia.discovery.lc.threads;

public class T5_InterruptedCollaborative {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                longLoop1();
            }
            Thread.currentThread().interrupt();
        });
        thread.start();

        Thread.sleep(1000L);

        thread.interrupt();
    }

    private static void longLoop1() {
        while (!Thread.interrupted()) {
            longLoop2();
        }
        Thread.currentThread().interrupt();
    }

    private static void longLoop2() {
        while (!Thread.interrupted()) {
            // do stuff
        }
        Thread.currentThread().interrupt();
    }
}

/*
improvements:
  - collaborative: interrupt must be propagated

limitations:
  - collaborative: code can hide the interrupt status from its callers
  - what happens to Thread.sleep() and other synchronization mechanism?
*/
