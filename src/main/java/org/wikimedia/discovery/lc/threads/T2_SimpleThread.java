package org.wikimedia.discovery.lc.threads;

public class T2_SimpleThread {

    private static final class SomeTask implements Runnable {

        private volatile boolean running;

        @Override
        public void run() {
            running = true;
            while (running) {
                // do stuff
            }
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SomeTask task = new SomeTask();
        new Thread(task).start();

        Thread.sleep(1000L);

        task.stop();
    }

}

/*
improvements:
  - can now be stopped on demand

limitations:
  - only checks `running` once per iteration
  - what happens if "do stuff" is running for a long time
  - what happens if "do stuff" is block (on IO, synchronization, ...)
  - this looks like a generic problem, is there a generic solution
*/