import java.util.Scanner;
public class CHEFROUT {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        String[] log=new String[t];
        for(int i=0;i<t;++i)log[i]=in.next();
        for(int j=0;j<t;++j){
            String s=log[j];
            boolean logOK=true;
            for(int i=1;i<s.length();++i){
                if(s.charAt(i-1)=='E' && s.charAt(i)=='C'){
                    logOK=false;
                    break;
                }else if(s.charAt(i-1)=='S' && (s.charAt(i)=='E'||s.charAt(i)=='C')){
                    logOK=false;
                    break;
                }
            }
            if(logOK)System.out.println("yes");
            else System.out.println("no");
        }
    }

}