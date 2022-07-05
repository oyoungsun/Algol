import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static int adj[][];
    static int route[][];
    static int N;
    static Queue<Integer> q;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
        //    q[i] = new LinkedList<>();
            for(int j=0; j<N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                for(int k=0; k<N; k++)
                    if (adj[j][i]==1 && adj[i][k]==1)
                        adj[j][k]=1;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(adj[i][j]));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
