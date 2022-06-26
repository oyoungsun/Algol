import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<Integer> graph[];
    static int count=0;
    static boolean visit[];
    public static void main(String agrs[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++){
            visit[i]=false;
            graph[i] = new ArrayList<>();
        }
        //graph 구현
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            graph[e1].add(e2);
            graph[e2].add(e1);
        }
        //dfs()
        for(int i=1; i<=n; i++){
            if(visit[i]==false) {
                visit[i]=true;
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
        return;
    }
    public static void dfs(int start){
        for(int i=0; i<graph[start].size(); i++){
            if(visit[graph[start].get(i)]==false){
                visit[graph[start].get(i)]=true;
                dfs(graph[start].get(i));
            }
        }
        return;
    }
}
