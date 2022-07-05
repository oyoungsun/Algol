import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1},{-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int island[][];
    static boolean visit[][];
    static int w,  h;

    public static void main(String[] args) throws IOException {
        //while testase(0 . 0일때까지 반복)
        while(true) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int cnt=0;
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(h==0&&w==h) break;

            island = new int[w][h];
            visit = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                    visit[i][j] = false;
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (visit[i][j] == false && island[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        return;
    }
    public static void dfs(int x,int y){
        for(int i=0; i<8; i++){
            int nx= x + dir[i][0];
            int ny =y + dir[i][1];
            if (nx<0||ny<0||nx>=w||ny>=h) continue;
            if(island[nx][ny]==1) {
                if (visit[nx][ny]==true) continue;
                visit[nx][ny]= true;
                dfs(nx, ny);
            }
        }
        return;
    }
}
