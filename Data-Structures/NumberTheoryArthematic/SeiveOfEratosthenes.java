package NumberTheoryArthematic;

import java.util.*;

public class SeiveOfEratosthenes {
    public static ArrayList<Integer> generatePrimes(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true); // assume all are primes
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= n; i++){
            if(isPrime[i])
                for(int j = i*i; j <= n; j += i) // j = i*2 will already be marked by smaller nums
                    isPrime[j] = false;
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(isPrime[i]) primes.add(i);
        }
        return primes;
    }
    public static ArrayList<Integer> primeFacotorization(int n, ArrayList<Integer> primes){
        ArrayList<Integer> factors = new ArrayList<>();
        for(int prime: primes){
            if(prime * prime > n) break;
            while (n % prime == 0){
                n /= prime;
                factors.add(prime);
            }
        }
        if(n > 1) factors.add(n);
        return factors;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primes = generatePrimes(n);
        System.out.println(primes);
        ArrayList<Integer> factors = primeFacotorization(n,primes);
        System.out.println(factors);
    }
}