package NumberTheoryArthematic;

import java.util.Scanner;

public class GCDLCM {
    public static int gcd(int a, int b){
        if(a < b) return gcd(b,a);
        while (b != 0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a; // GCD (a,0) -> a
    }
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcdRes = gcd(a,b);
        int lcmRes = lcm(a,b);
        System.out.println("GCD: "+gcdRes);
        System.out.println("LCM: "+lcmRes);
    }
}
