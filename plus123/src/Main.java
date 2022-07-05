import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dp[];
    public static void main(String args[]) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(2);
            } else if (n == 3) {
                System.out.println(4);
            } else {
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;//dp[4] = dp[3]+dp[2]+dp[1] dp[5]= dp4, dp3, dp2
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                System.out.println(dp[n]);
            }
        }
    }
}