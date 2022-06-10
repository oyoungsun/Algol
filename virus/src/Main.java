import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int count = -1;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int n, e;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visit[i] = false;
        }

        makeNode();
        dfs(1);
        System.out.println(count);
        return;
    }

    public static void makeNode() throws IOException {

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

    }

    public static void dfs(int node) {
        if (visit[node]) {
            return;
        } else {
            count++;
            visit[node] = true;
            for (int next : graph[node]) {
                if (!visit[next]) {
                    dfs(next);
                }
            }
        }
        return;
    }
}
