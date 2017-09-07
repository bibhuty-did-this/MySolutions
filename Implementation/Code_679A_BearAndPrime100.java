/**
 * Author: o_panda_o
 * Email: emailofpanda@yahoo.com
 */
import java.util.Scanner;

public class Code_679A_BearAndPrime100{

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int[] primes={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,4,9,25,49};
        int counter=0;
        for(int p:primes){
            System.out.println(p);
            System.out.flush();
            counter+=(in.next().equals("yes")?1:0);
        }
        System.out.println((counter>1?"composite":"prime"));;
    }
}