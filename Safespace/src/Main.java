import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n, maxhigh=0, maxSafe=0;
    static int map[][];
    static boolean visit[][];
    public static void main(String []args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxhigh<map[i][j]) maxhigh = map[i][j];
            }
        }
        for(int h=0; h<=maxhigh; h++) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) visit[i][j]=false;
            int cnt=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j] == false && map[i][j] > h) {
                        dfs(h,i,j);
                        cnt++;
                    }
                }
            }
            if(maxSafe<cnt) maxSafe = cnt;
        }
        System.out.println(maxSafe);
    }
    public static void dfs(int h,int x, int y){
        visit[x][y]= true;
        for(int i=0; i<4; i++){
            int nx= x+dir[i][0];
            int ny= y+dir[i][1];
            if(nx<0||ny<0||nx>=n||ny>=n) continue;
            if(map[nx][ny]>h&&visit[nx][ny]==false)
                dfs(h, nx, ny);
        }
    }
}
