import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static char map[][];
    static boolean visit[] = new boolean[26];
    static int max=0;
    public static void main(String []args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        map = new char[R+1][C+1];
        for(int i=0; i<26; i++) visit[i]=false;
        for(int i=1; i<R+1; i++){
            String input = br.readLine();
            for(int j=1; j<C+1; j++){
                map[i][j] = input.charAt(j-1);
            }
        }
        dfs(1,1, map[1][1],1);
        System.out.println(max);
    }
    public static int dfs(int x, int y, char alpha, int cnt){
        int count = cnt;
        visit[alpha-'A'] = true;
        for(int i=0; i<4; i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<1||ny<1||nx>R||ny>C) continue;
            if(visit[map[nx][ny]-'A']==false){
                visit[map[nx][ny]-'A']=true;
                count = dfs(nx,ny,map[nx][ny], cnt+1);
                visit[map[nx][ny]-'A']=false; //다른 루트도 가봐야하기때문에
            }
        }
        if(max < count) max = count;
        return max ;
    }
}
