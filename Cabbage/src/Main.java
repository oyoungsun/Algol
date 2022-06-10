import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
    static int testcase;
    static int w, h, n;
    static boolean map[][];
    static boolean visit[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static public void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++)
            extracted(sb);
        System.out.println(sb);
    }

    private static void extracted(StringBuilder sb) throws IOException {
        int count =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new boolean[w][h];
        visit = new boolean[w][h];
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++) {
                map[i][j] = false;
                visit[i][j] = false;
            }
        }

        makeMap();
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                if(visit[i][j]==true)
                    continue;
                if (map[i][j] == true) {
                        dfs(i, j);
                        count++;
                    }
                }
        }
        sb.append(count).append("\n");
    }

    static public void makeMap() throws IOException {
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2]=true;
        }
    }
    static public void dfs(int x, int y){
        int nextX, nextY;
        for(int i=0;i<4; i++){
            nextX = x+dir[i][0];
            nextY = y+dir[i][1];
            if(-1>=nextY||nextY>=h||-1>=nextX||nextX>=w)
                continue;
            if(visit[nextX][nextY]==false){
                visit[nextX][nextY]=true;
                if (map[nextX][nextY]==true) {
                    dfs(nextX, nextY);

            }}
        }
        return;
    }
}
