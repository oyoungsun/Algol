import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dp[];
    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            if(i==1) dp[i]=1;
            else if(i==2) dp[i]=2;
            else dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}