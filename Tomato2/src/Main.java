import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node{
    int h;
    int x;
    int y;
    int day;
    public node(int h, int x, int y, int day){
        this.x = x;
        this.y = y;
        this.h = h;
        this.day = day;
    }
}
public class Main {
    static int n, m, h;
    static int [][][]box;
    static int dir[][] = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<node> q;
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        box = new int[h][n][m];
        for(int k=0; k<h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[k][i][j]=Integer.parseInt(st.nextToken());
                }
            }
        }
        if(!anyZero()) {
            System.out.println(0);
            return;
        }//all 1, print 0

        for(int k=0; k<h; k++) //find tomato
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (box[k][i][j] == 1) q.add(new node(k, i, j, 0));


        int day = bfs();
        if (anyZero()) System.out.println(-1); //still 0, print -1
        else System.out.println(day);
    return; //main
    }

    public static boolean anyZero(){
        for(int k=0; k<h; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (box[k][i][j]==0) return true;
        return false;
    }
    public static int bfs(){
        int day=0;
        int nh, nx,ny;

        while(!q.isEmpty()){
            node now = q.poll();
            for(int i=0; i<6; i++) {
                nh= now.h + dir[i][0];
                nx = now.x + dir[i][1];
                ny = now.y + dir[i][2];
                day = now.day +1;
                if(nh<0||nh>=h||nx<0||nx>=n||ny<0||ny>=m) continue;
                if(box[nh][nx][ny]==0){
                    q.add(new node(nh,nx,ny, day));
                    box[nh][nx][ny]=day; //익은 토마토
                }
            }
        }
        return day-1;
    }
}