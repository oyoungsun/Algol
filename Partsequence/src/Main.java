import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//오름차순 부분 수열 만들기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[];
    static int[] dp;
    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        int ans=1;
        for(int i=2; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(dp[i]<=dp[j] && arr[i]>arr[j]){ //값이 더 큰데도 길이가 짧다면
                    dp[i] = dp[j]+1;
                }
            }
            ans = Math.max(ans, dp[i]); //가장큰 길이
        }
        System.out.println(ans);
        return;
    }
}