package restart.dsa.math;

public class GCD {

    // a=bq+r;
    // r=(a-bq)
    // So if there's a number that divides both a and b, it should divide r
    // r is ideally a%b
    // So if a number divides a and b, it'll also divide a, a%b and b, a%b

    // Time Complexity: (O(log(min(a,b)))
    public int gcd(int a, int b){// a>b
        if(b==0) return a;
        else return gcd(b, a%b);
    }


    // gcd*lcm=num
    // hcf*lcm=num
    public int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args) {
        var gcd=new GCD();
        System.out.println(gcd.gcd(3,5));
    }
}
