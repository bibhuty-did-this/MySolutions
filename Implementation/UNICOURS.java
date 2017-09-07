/**
 * Author: o_panda_o
 * Email: emailofpanda@yahoo.com
 */

import java.util.Scanner;

public class UNICOURS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while (t-->0){
            int n=in.nextInt();
            int taken=0,availaible=0;
            while (n-->0){
                int get=in.nextInt();
                if(taken>=get){
                    ++availaible;
                }else{
                    availaible-=(get-taken);
                    taken+=(get-taken);
                    ++availaible;
                }
            }
            System.out.println(availaible);
        }
    }
}
