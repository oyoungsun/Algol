import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point{
    int x;
    int y;
    int cnt;
    point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Main {
    static int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int copy[][];
    static int map[][];
    static int n, m;
    static int min;
    public static void main(String []args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copy = new int[n][m];
        min = n*m +1;
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = input.charAt(j) - '0';
                //copy[i][j] = map[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(map[i][j]==1){
                    map[i][j]=0;
                    int count = findMin();
                    map[i][j]=1;
                    if(min>count) min = count; //통과 못하는 경우를 만들어야함 ..
                }
            }
        }
        if(min>= n*m +1) {bw.write(-1);}
        else{ bw.write(min);}
    }
    public static int findMin(){//bfs
        Queue<point> q = new LinkedList<>();
        int count=0;
        q.add(new point(0,0,1));
        boolean [][] visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j]=false;
            }
        }
        visit[0][0] = true;
        while(!q.isEmpty()){
            point now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                count = now.cnt+1;
                if(nx==n-1&&ny==m-1) return count; //탈출
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visit[nx][ny]==false&&map[nx][ny]==0){
                    visit[nx][ny] = true;
                    q.add(new point(nx, ny, count));
                }
            }

        }
        return 101;
    }

}
