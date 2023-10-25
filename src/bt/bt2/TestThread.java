package bt.bt2;

 class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class EvenThread extends Thread {
    @Override
    public void run() {
        try {
            // Đợi OddThread hoàn thành trước khi xuất số chẵn
            Thread oddThread = new OddThread();
            oddThread.start();
            oddThread.join();

            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        evenThread.start();
    }
}
