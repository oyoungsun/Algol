import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int stair[];
    static int sum[];
    static boolean visit[];

    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        stair = new int[n+1];
        sum = new int[n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
            visit[i]= false;
        }
        if(n==1){
            System.out.println(stair[1]);
            return;

        }else if(n==2){
            System.out.println(stair[2]+stair[1]);
            return;
        }
        stair[0]=0;
        visit[0]=true;
        sum[1] = stair[1];
        visit[1]=true;
        sum[2] = stair[1]+stair[2];
        visit[2]=true;

        dp(n);
        System.out.println(sum[n]);
        return;
    }
    public static int dp(int n){
        if(visit[n]==false){
            sum[n] = Math.max(dp(n-3)+stair[n-1], dp(n-2)) + stair[n];
            visit[n]=true;
        }
        return sum[n];
    }
}