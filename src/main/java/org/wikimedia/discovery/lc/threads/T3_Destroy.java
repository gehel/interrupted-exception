package org.wikimedia.discovery.lc.threads;

import java.util.Random;

public class T3_Destroy {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // do stuff
            }
        });
        thread.start();

        Thread.sleep(1000L);

        if (new Random().nextBoolean()) thread.stop();
        else thread.destroy();
    }

}

/*
improvements:
  - looks easy and minimal

limitations:
  - Thread.stop()
    - deprecated since Java 1.2
    - worked by propagating a ThreadDeath unchecked exception up the call stack
    - released all monitors, which could exposed objects protected by those monitors in an inconsistent state
  - Thread.destroy() has never been implemented
    - deprecated since Java 1.5
    - throws exception since Java 8
    - entirely removed since Java 10
note:
  - this is one of the reason why catching Throwable without rethrowing it untouched is a terrible idea
*/
