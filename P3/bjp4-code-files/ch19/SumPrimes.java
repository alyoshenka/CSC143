// programming project to add up the first n primes; used to explore various
// efficiency improvements
//
// for inefficient isPrime, not parallel, checking odds & evens, first 10k:
//     time = 32.595
//     sum = 496165411
//
// for efficient isPrime2, not parallel, checking odds & evens, first 10k:
//     time = 0.237
//     sum = 496165411
//
// for efficient isPrime2, not parallel, checking only odds, first 10k:
//     time = 0.145
//     sum = 496165411
//
// for efficient isPrime2, not parallel, checking only odds, first 20k:
//     time = 0.322
//     sum = 2137755325
//
// for efficient isPrime2, parallel, checking only odds, first 20k:
//     time = 0.411
//     sum = 2137755325
//
// was able to add up this many without overflow:
//     How many primes do you want to add up? 20043
//     time = 0.414
//     sum = 2147431330


import java.util.stream.*;
import java.util.*;

public class SumPrimes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many primes do you want to add up? ");
        int count = console.nextInt();
        int sum = sumPrimes(count);
        System.out.println("sum = " + sum);
    }

    // returns the sum of the first count primes, reporting the elapsed time
    // for the computation
    public static int sumPrimes(int count) {
        if (count <= 0) {
            return 0;
        } else {
            long start = System.currentTimeMillis();
            int sum = IntStream.iterate(1, n -> n + 2)
                .parallel()
                .filter(SumPrimes::isPrime2)
                .limit(count - 1)
                .sum() + 2;
            double elapsed = (System.currentTimeMillis() - start) / 1000.0;
            System.out.println();
            System.out.println("time = " + elapsed);
            return sum;
        }
    }

    public static boolean isPrime(int n) {
        return IntStream.range(1, n + 1)
            .filter(x -> n % x == 0)
            .count()
            == 2;
    }

    public static boolean isPrime2(int n) {
        if (n == 1) {
            return false;
        } else {
            int root = (int) Math.sqrt(n);
            return IntStream.range(1, root + 1)
                .filter(x -> n % x == 0)
                .count()
                == 1;
        }
    }
}
