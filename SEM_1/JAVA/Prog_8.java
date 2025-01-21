package Prog_sem1;

class Number extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Letter extends Thread {
    public void run() {
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println("Letter: " + ch);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Prog_8 {
    public static void main(String[] args) {
        Thread t1 = new Number();
        t1.start();
        
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t2 = new Letter();
        t2.start();
    }
}
