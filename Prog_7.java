package Prog_sem1;

class Number1 implements Runnable {
	int start;
    int end;

    public Number1(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class Number2 implements Runnable {
	int start;
    int end;

    public Number2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class Prog_7 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Number1(1, 5), "Thread 1");
        Thread t2 = new Thread(new Number2(6, 10), "Thread 2");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        
    }
}
