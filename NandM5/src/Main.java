import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n;
    static int list[];
    static int arr[];
    static boolean visit[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        list = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++)
            visit[i]=false;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(list);//내림차순
        dfs(0);
        return;
    }
    public static void dfs(int depth){
        if (depth == m) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = list[i];
                dfs(depth + 1);
                visit[i]=false;
            }
        }
    }
}
