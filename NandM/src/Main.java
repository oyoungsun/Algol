import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    List<Integer> edge;
}
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static boolean visit[];
    static int[] arr;
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[m];

        for(int i=0; i<n; i++){
                visit[i]=false;
        }
        visit2( 0);
        return;
    }
    public static void visit2(int depth){
        if(depth == m){
            for(int v : arr){
            System.out.print(v+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) { //3
            if (visit[i] != true) {
                visit[i] = true;
                arr[depth] = i+1;
                visit2(depth + 1);
                visit[i] = false; // 4
            }
        }
        return;
    }
}
