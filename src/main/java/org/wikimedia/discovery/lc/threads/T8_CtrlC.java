package org.wikimedia.discovery.lc.threads;

public class T8_CtrlC {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                // do stuff
            }
            System.out.println("exit");
        });
        thread.start();

        thread.join();
    }

}
