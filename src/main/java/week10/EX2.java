package week10;

class UseRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("UseRunnable run() method.");
    }
}

class UseThread extends Thread {
    public void run() {
        System.out.println("UseThread run() method.");
    }
}

class ThreadSample {
    public static void main(String[] args) {
        UseRunnable useRunnable = new UseRunnable();
        UseThread useThread = new UseThread();

        new Thread(useRunnable).start();
        useThread.start();

        System.out.println("ThreadSample program ends");
    }
}