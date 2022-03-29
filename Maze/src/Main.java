import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int x;
    int y;
    int dir;

    Node(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
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
        System.out.println(findPath(new Node(n,m,0)));

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
        Stack<Node> stack = new Stack<>();
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

        Node start = new Node(1,1, 0);

        Node now = new Node(1,1,0);
        Node next = new Node(1,1,0);
        //now = next = start; 이거 고치기
        stack.push(start);
        pathcount++;
        while(now.x!=4 && now.y!=6){
            now = stack.pop();
            visit[now.x][now.y] = true;
            for(int i=now.dir; i<4; i++){ //여기가 아닌듯
                next.x = now.x + dir[i][0];
                next.y = now.y + dir[i][1];
                next.dir = 0;
                if(maze[next.x][next.y]==1 && !visit[next.x][next.y]) {//갈 수 있으면
                   //is next can go?(1) in Maze && not in visit(0)
                    if(next.x==4&&next.y==6){
                        pathcount++;
                        System.out.println("exit");
                        break;
                    }
                    pathcount++;
                    now.dir=i;
                    stack.add(new Node(now.x,now.y,now.dir));
                    now.x = next.x;
                    now.y = next.y; //이 경우에 방향도 초기화해야함
                    now.dir=0;
                    i=-1;
                }
                else {
                    next.x = now.x; //복구하고 다음방향
                    next.y = now.y;
                }
                visit[next.x][next.y] = true;
            } //dir 모두 막혀있음. && 모두 방문해봤음 -> stack 복구해서 다른 방향으로 가봐야함.
        }
        return pathcount;
    }
}

//뒤돌아갈 path를 스택에 담아서 기억. (최근에 방문한거부터 복구해야하니까)

