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
//    static int[][] maze = {{0,0,0,0,0,0,0},
//                            {0,1,0,1,1,1,1,0},
//                            {0,1,0,1,0,1,0,0},
//                            {0,1,0,1,0,1,1,0},
//                            {0,1,1,1,0,1,1,0},
//                            {0,0,0,0,0,0,0,0}};
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        makeMaze(); //가장자리 0으로 테투리 만들기
        //System.out.println(Arrays.deepToString(maze));
        System.out.println(findPath(new Node(n,m)));

    }
    public static void makeMaze() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        maze = new int[n+2][m+2];
        for(int i = 1; i <= n; i++){
            String input = br.readLine();
            for(int j = 1; j <= m; j++) {
                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }
        for(int i=0; i<=n+1; i++){
            maze[i][0] = 0;
            maze[i][m+1] = 0;
        }
        for(int j=0; j<=m+1; j++){
            maze[0][j]=0;
            maze[n+1][j]=0;
        }
    //

    }

    public static Integer findPath(Node exit){
        boolean[][] visit;
        Queue<Node> queue = new LinkedList<>();
        int pathcount = 0;

        visit = new boolean[exit.x+2][];
        for(int i=0; i<=exit.x+1; i++){
            visit[i] = new boolean[exit.y+2];
            visit[i][0] = true;
            for(int j=1; j<=exit.y; j++)
                visit[i][j]=false; //visit 초기화
            visit[i][exit.y+1] = true;
        }
        for(int j=0; j<=exit.y+1; j++){
            visit[0][j]=true;           //visit mapping
        }
        for(int j=0; j<=exit.y+1; j++){
            visit[exit.x+1][j]=true;    //visit mapping
        }

        Node start = new Node(1,1);
        int status = 0;

        Node now = new Node(1,1);
        Node next = new Node(1,1);
        //now = next = start; 이거 고치기
        queue.offer(start);
        while(now.x!=exit.x || now.y!=exit.y){ //x,y둘중에 하나라도 출구 아님
            now = queue.poll();
            if(now == null){
                System.out.println("null");
                break;
            }
            pathcount++;
            visit[now.x][now.y] = true;
            for(int i=0; i<4; i++){ //여기가 아닌듯
                next.x = now.x + dir[i][0];
                next.y = now.y + dir[i][1];
                if(maze[next.x][next.y]==1 && !visit[next.x][next.y]) {//갈 수 있으면
                   //is next can go?(1) in Maze && not in visit(0)
                    if(next.x==exit.x&&next.y==exit.y){ //출구와 일치
                        pathcount++;
                        System.out.println("exit");
                        return pathcount;
                    }
                    status++; //한가지라도 있을 경우
                    queue.offer(new Node(next.x,next.y));
                }
                visit[next.x][next.y] = true;
            } //dir모두 방문함
            if(status == 0){
                pathcount--; //방문할 가지가 없는 경우 방문 안한 것으로 침
            }

        }
        System.out.println("can't find exit");
        return 0;
    }
}

//뒤돌아갈 path를 스택에 담아서 기억. (최근에 방문한거부터 복구해야하니까)

