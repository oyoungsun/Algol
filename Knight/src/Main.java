import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class node{
    int x;
    int y;
    int act;
    public node(int x, int y, int act){
        this.x = x;
        this.y = y;
        this.act = act;
    }
}
public class Main {
    static int testcase;
    static int I;
    static int sx, sy, ex,ey;
    static int [][]dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    static boolean visit[][];
    static int act = 0;
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws NumberFormatException, IOException {
        Scanner sc =new Scanner(System.in);

        //StringTokenizer st;
        testcase = sc.nextInt();//Integer.parseInt(br.readLine());
        StringBuffer bf =new StringBuffer();
        for(int t = 0; t<testcase; t++) {
            I = sc.nextInt();//Integer.parseInt(br.readLine());
            //setting
            visit = new boolean[I][I];
           // st = new StringTokenizer(br.readLine());
            sx = sc.nextInt();//Integer.parseInt(st.nextToken());
            sy = sc.nextInt();//Integer.parseInt(st.nextToken());
           // st = new StringTokenizer(br.readLine());
            ex =sc.nextInt();// Integer.parseInt(st.nextToken());
            ey =sc.nextInt();// Integer.parseInt(st.nextToken());
           // if(sx==ex&&sy==ey) {System.out.println(0); return;}
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < I; j++) {
                    visit[i][j] = false;
                }
            }
            bfs(sx, sy);
        }
        return;
    }
    public static void bfs(int x, int y){
        Queue<node> q = new LinkedList<>();
        q.add(new node(x, y,0));
        visit[x][y] = true;
        while(!q.isEmpty()) {
            node now = q.poll();
            if(now.x==ex&&now.y==ey) {
                System.out.println(now.act);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                act = now.act +1;
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if (visit[nx][ny] == false) {
                    visit[nx][ny] = true;
                    q.add(new node(nx, ny, act));
                }
            }
        }
        return;
    }
}
