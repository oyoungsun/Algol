import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int list[];
    static int arr[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        list = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(list);
        dfs(0,0);
        return;
    }
    public static void dfs(int depth, int index){
        if (depth == m) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }

        for(int i=index; i<n; i++){
            arr[depth]=list[i];
            dfs(depth+1, i+1);
        }
    }
}
