package bt.bt3;

import java.util.ArrayList;
import java.util.List;

class LazyPrimeFactorization implements Runnable {
    private List<Integer> primeNumbers = new ArrayList<>();
    private int maxNumber;

    public LazyPrimeFactorization(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        for (int num = 2; num <= maxNumber; num++) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(num);
                System.out.println("Lazy Prime: " + num);
            }
        }
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }
}
class OptimizedPrimeFactorization implements Runnable {
    private List<Integer> primeNumbers = new ArrayList<>();
    private int maxNumber;

    public OptimizedPrimeFactorization(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        for (int num = 2; num <= maxNumber; num++) {
            boolean isPrime = true;
            int sqrtNum = (int) Math.sqrt(num);
            for (int i = 2; i <= sqrtNum; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(num);
                System.out.println("Optimized Prime: " + num);
            }
        }
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }
}

public class Main {
    public static void main(String[] args) {
        int maxNumber = 100;

        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization(maxNumber);
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization(maxNumber);

        Thread lazyThread = new Thread(lazyPrimeFactorization);
        Thread optimizedThread = new Thread(optimizedPrimeFactorization);

        lazyThread.start();
        optimizedThread.start();
    }
}
