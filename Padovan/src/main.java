import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        int dp[] = new int [101];
        int n;
        for(int i=0; i<testcase; i++){
            n  = Integer.parseInt(br.readLine());
            if(n==1){
                System.out.println(1);
            }
            else if(n==2){
                System.out.println(1);
            }
            else {
                dp[1]=1;
                dp[2]=1;
                dp[3]=1;
                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
                System.out.println(dp[n]);
            }
        }
        return;
    }
}