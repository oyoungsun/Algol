import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int num;

    Node(int n) {
        this.num = n;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static Queue<Node> q = new LinkedList<>();
    static int[] visit = new int[100001];

    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Node start = new Node(n);
        if (n == k) {
            System.out.println(0);
        } else {
            q.add(start);
            bfs();
        }
        return;
    }

    public static void bfs() {
        visit[n] = 1;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now.num + 1;
                else if (i == 1) next = now.num - 1;
                else next = now.num * 2;
                if (next == k) {
                    System.out.println(visit[now.num]);
                    return;
                }
                if (next >= 0 && next < 100001 && visit[next] == 0) {
                    q.add(new Node(next));
                    visit[next] = visit[now.num] + 1;
                }

            }
        }
    }
}