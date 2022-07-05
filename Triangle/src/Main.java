import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer ans[][];
    static int arr[][];
    static int depth;
    public static void main(String args[]) throws IOException {
        depth = Integer.parseInt(br.readLine());
        arr = new int[depth][depth];
        ans = new Integer[depth][depth];
        for(int i=0; i<depth; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<depth; i++){
            ans[depth-1][i] = arr[depth-1][i];
        }
        System.out.println(dp(0,0));
    }
    public static int dp(int n, int index){
        if(n==depth-1) return ans[n][index];
        if(ans[n][index]==null)
            ans[n][index] = Math.max(dp(n+1,index), dp(n+1,index+1)) + arr[n][index];
        return ans[n][index];
    }
}

