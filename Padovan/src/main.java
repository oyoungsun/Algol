import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int dp[] = new int [101];
        int testcase = Integer.parseInt(br.readLine());


            dp[1]=1;
            dp[2]=1;
            dp[3]=1;
            for (int j = 4; j <= 100; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
        for(int i=0; i<testcase; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);

        }
        return;
    }
}