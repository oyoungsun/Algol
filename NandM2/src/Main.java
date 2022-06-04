import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;

    static int[] arr;
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0,1);
        return;
    }
    public static void dfs(int depth, int start){
        if(depth == m){
            for(int v : arr){
                System.out.print(v+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=n; i++) {
            arr[depth]=i;
            dfs(depth+1, i+1); //start+1이 아니라 i+1..
            }
        return;
    }
}

