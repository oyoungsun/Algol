import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long dp[][];
    static long mod = 1000000000;

    public static void main(String args[]) throws IOException {
        int d = Integer.parseInt(br.readLine()); //입력 받는 수는 계단 수의 자릿수
        dp = new long[d+1][10];
        long sum=0;
        for (int k = 1; k < 10; k++) {
            dp[1][k] = 1;
        }
        for (int i = 2; i <= d; i++) {
            dp[i][0] = dp[i - 1][1]%mod;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1] %mod;
            }
            dp[i][9] = dp[i-1][8] %mod;
        }
        for(int k=0; k<10; k++){
            sum +=dp[d][k];
        }
        System.out.println(sum % mod);
    }
}
