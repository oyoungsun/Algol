import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int pC=0, sC=0;
    static boolean visit[][];
    static char map[][];
    public static void main(String []args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N][N];
        map = new char[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                 map[i][j] = input.charAt(j);
                 visit[i][j] = false;
            }
        }
        //nomal people()
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='R'&&visit[i][j]==false) {
                    people('R', i, j);
                    pC++;
                }
                if(map[i][j]=='G'&&visit[i][j]==false){
                    people('G', i, j );
                    pC++;
                }
                if(map[i][j]=='B'&&visit[i][j]==false){
                    people('B', i, j);
                    pC++;
               }

            }
        }
       // sick();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='R'||map[i][j]=='G'){
                    map[i][j] ='A';
                }
                visit[i][j] = false;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='A'&&visit[i][j]==false) {
                    people('A', i, j);
                    sC++;
                }
                if(map[i][j]=='B'&&visit[i][j]==false){
                    people('B', i, j);
                    sC++;
                }

            }
        }
        System.out.println(pC+" "+sC);
    }
    public static void people(char A, int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(visit[nx][ny]==true) continue;
            if(map[nx][ny]==A) people(A, nx, ny);
        }
    }
    public static void sick(char A, int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(visit[nx][ny]==true) continue;
            if(map[nx][ny]==A) people(A, nx, ny);
        }
    }
}
