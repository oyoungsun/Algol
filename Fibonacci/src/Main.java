import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Count{
    int ze;
    int on;
    Count(int ze, int on){
        this.ze = ze;
        this.on = on;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dp[][];
    public static void main(String args[]) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int j=0; j<40; j++) visit[j]=false;
        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n+1][2];
            fiboCount(n);
        }
    }

    public static void fiboCount(int n) {
        if (n == 0) {
            System.out.println("1 0");
        }else if (n == 1) {
            System.out.println("0 1");
        }else {
            dp[0][0]=1;
            dp[0][1]=0;
            dp[1][0]=0;
            dp[1][1]=1;
            for (int i = 2; i <= n; i++) {
                    dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                    dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            System.out.println(dp[n][0]+" "+dp[n][1]);
        }
    }
}

