import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node{
    int x;
    int y;
    public node(int x, int y){
        super();
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int lab[][];
    static int temp_wa[][];
    static int temp_vi[][];

    static int max=0; //최대 안전 영역
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab= new int[n][m];
        temp_wa= new int[n][m];
        temp_vi= new int[n][m];
//연구실 구현하기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                temp_wa[i][j] = Integer.parseInt(st.nextToken());
               // temp_wa[i][j] = lab[i][j];

            }
        }
        wall(0);
        System.out.println(max);
        return;
    }
    public static void wall(int wallCnt){ //완전탐색 알고리즘 , dfs
        if(wallCnt==3){
            virus(); //virus 채우고 0세기
            cntZero();
            return; //이걸안해줘서......끝이안남.........
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
            if(temp_wa[i][j] == 0){
                temp_wa[i][j] = 1;
                wall(wallCnt+1);
                temp_wa[i][j] = 0; //복구
                }
            }
        }
    }
    public static void virus(){ //virus bfs()
        Queue<node> q = new LinkedList<node>();
        for(int i=0; i<n; i++){ //copy
            for(int j=0; j<m; j++){
                temp_vi[i][j] = temp_wa[i][j];
            }}
        for(int i=0; i<n; i++){ //first visrus
            for(int j=0; j<m; j++){
                if(temp_vi[i][j]==2){
                    q.add(new node(i,j));
                }
            }}
        while(!q.isEmpty()){
            node now = q.poll();
            for(int i=0; i<4; i++){
                int nx =  now.x + dir[i][0];
                int ny =  now.y + dir[i][1]; //이걸 y가아니라 또 x라고적고있네..에혀
                if(nx>=n||nx<0||ny>=m||ny<0) continue;
                if(temp_vi[nx][ny]==0){
                    temp_vi[nx][ny]=2;
                    q.offer(new node(nx,ny));
                }
            }
        }
        return;
    }
    public static void cntZero(){
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(temp_vi[i][j]==0) cnt++;
            }
        }
        if(max<cnt) max = cnt;
        return;
    }
}