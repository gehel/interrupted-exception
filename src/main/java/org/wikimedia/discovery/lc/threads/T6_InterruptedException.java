package org.wikimedia.discovery.lc.threads;

public class T6_InterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                doSleep();
            }
        });
        thread.start();

        Thread.sleep(1000L);

        thread.interrupt();
    }

    private static void doSleep() {
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
improvements:
  - sleeping / blocked threads can be interrupted

limitations:
  - collaborative: code can hide the interrupt status from its callers
*/
