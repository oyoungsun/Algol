import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] dir = { {-1, 0}, {0, -1}, {1, 0},{0, 1}};
    static int[][] maze;

    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        makeMaze(); //가장자리 0으로 테투리 만들기
        System.out.println(findPath(new Node(n,m)));
    }
    public static void makeMaze() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }
    }

    public static Integer findPath(Node exit){
        Queue<Node> queue = new LinkedList<>();
        int pathcount = 0;
        boolean[][] visit = new boolean[exit.x][exit.y];
        visit[0][0] = true;

        Node now = new Node(0,0);
        Node next = new Node(0,0);

        queue.add(new Node(0,0));
        while(!queue.isEmpty()){//now.x!=exit.x || now.y!=exit.y){ //x,y둘중에 하나라도 출구 아님
            now = queue.poll();
            visit[now.x][now.y] = true;
            for(int i=0; i<4; i++){
                next.x = now.x + dir[i][0];
                next.y = now.y + dir[i][1];
                //출구 거나, 0보다 작아지는 경우
                if(next.x<0||next.y<0||next.x>=exit.x||next.y>= exit.y){
                    continue;
                }
                if(visit[next.x][next.y]||maze[next.x][next.y]==0){
                    continue;
                }
                    queue.add(new Node(next.x,next.y));
                    maze[next.x][next.y] = maze[now.x][now.y] + 1;
                    visit[next.x][next.y] = true; //두줄이 이해가 안됨
                //}
            } //dir모두 방문함
        }
        return maze[exit.x-1][exit.y-1];
    }
}

//뒤돌아갈 path를 스택에 담아서 기억. (최근에 방문한거부터 복구해야하니까)

