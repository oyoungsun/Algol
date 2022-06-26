import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int maze[][];
    static boolean visit[][];
    static int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    static Queue<Node> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int day=0;
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int last=0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[m][n];
        visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
                }
        }
        if(!anyZero()){
            System.out.println(0);
            return;
        } // first, there no zero, all 1
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){ //find all start point, they have to in queue
                if(maze[i][j]==1){
                    queue.add(new Node(i,j));
                }
            }
        }

        last = bfs();
        if(anyZero()){ // still anyZero? true - 1 ;
            System.out.println(-1);
        }
        else{        //No;
            System.out.println(last);
        }
        return;
    }
    public static int bfs(){
        Node now;
        int day=0;
        while (!queue.isEmpty()) {
            now = queue.poll();
            day = maze[now.x][now.y];
            visit[now.x][now.y] = true;
            for (int i = 0; i < 4; i++) {// in dir :
                Node next = new Node(0, 0);
                next.x = now.x + dir[i][0];
                next.y = now.y + dir[i][1];
                if (next.x == -1 || next.x == m || next.y == -1 || next.y == n)
                    continue; // not visit, not wall
                if (visit[next.x][next.y] == true)
                    continue;
                if (maze[next.x][next.y] == 0) {//next x, y ==0 ->1 && queue.add(next) && visit
                    maze[next.x][next.y] = maze[now.x][now.y] + 1; //이 줄이 중요하다.
                    queue.add(next);
                    visit[next.x][next.y] = true;
                } else if (maze[next.x][next.y] == -1) {
                    visit[next.x][next.y] = true;
                    continue;
                } //  == -1 && visit continue;
                //else //: another 1, 방문검사를 안한다(이미 방문했을수도, 안했을수도 있음);
                //queue에 있다면 안넣는다.
            }
        }
        return day - 1; //==day
    }
    public static boolean anyZero(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(maze[i][j]==0)
                    return true;
            }
        }
           return false;
    }
}
