import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dp[];
    static int arr[];
    public static void main(String args[]) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int [n+1];
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        dp[0]=-1001;
        arr[0]=0;
        int max=-1001;
        for(int i=1; i<=n; i++) {
            dp[i]=Math.max(arr[i],Math.max(dp[i-1]+arr[i], arr[i]+arr[i-1]));
        }
        for(int i=0; i<n; i++) {
            if (dp[i + 1] > max)
                max = dp[i + 1];
        }
        System.out.println(max);
    }
}
