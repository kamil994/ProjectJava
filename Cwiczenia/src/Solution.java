import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int[] used=new int[n];
        boolean b=true;
        int pairs=0;
        for (int i=0;i<ar.length;i++){
            b=true;
            for (int j=0;j<ar.length && b;j++){
                if (i!=j){
                    if (ar[i]==ar[j] && used[i]!=1 && used[j]!=1){
                        used[i]=1;
                        used[j]=1;
                        pairs+=1;
                        b=false;
                    }
                }
            }
        }
        return pairs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] a={10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(9,a);
        System.out.println(result);

    }
}
