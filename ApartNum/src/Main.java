import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node{
    int x;
    int y;

    node(int y, int x){
       this.y = y;
       this.x = x;
    }
}
public class Main {
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int apart[][];
    static boolean visit[][];
    static List<Integer> apartNum = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visit = new boolean[n][n];
        for(boolean [] vi : visit)
            for(boolean v : vi)
                v = false;
        apart = new int[n][n];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                apart[i][j] = input.charAt(j) - '0';
            }
        }
        search();

        Collections.sort(apartNum);

        System.out.println(apartNum.size());
        for(int n : apartNum)
            System.out.println(n);
    }

    private static Integer findApart(node start) {
        Stack<node> stack =new Stack<>();
        node next = new node(0,0);
        node now;
        int count=0;
        stack.push(start);
            count++;
            while(!stack.isEmpty()) {//4방향 모두 visit||0
                now = stack.pop();
                for(int i=0; i<4; i++){
                    next.y = now.y + dir[i][0];
                    next.x = now.x + dir[i][1];
                    if(-1>=next.y||next.y>=n||-1>=next.x||next.x>=n)
                            continue;
                    if (visit[next.y][next.x]==true) //이미 찾은 아파트일 수 있음 //나중에 지우고 다시해보기
                            continue;
                    visit[next.y][next.x]=true;
                    if(apart[next.y][next.x]==0)
                            continue;
                    stack.push(new node(next.y, next.x));
                    count++;
                }
            }

        return count;
    }
    private static void search() {
        int count = 0;

        for(int y=0; y<apart.length; y++){
        for(int x=0; x<apart[y].length; x++){
            //아파트찾기
            if (visit[y][x]==false) { //not visit
                visit[y][x]=true;
                if (apart[y][x] == 1) { //aprt 가 있다.
                    count = findApart(new node(y, x));
                    apartNum.add(count);   //단지수
                }
            }
        }}
        return;
    }

}