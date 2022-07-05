import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int visit[][];
    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        visit = new int[n][3];

        // 모든 경로 최소값을 찾아야 한다.
        //red부터 출발할때
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            visit[i][0]= Integer.parseInt(st.nextToken());
            visit[i][1]= Integer.parseInt(st.nextToken());
            visit[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<n; i++){
            visit[i][0] += Math.min(visit[i-1][1],visit[i-1][2]);
            visit[i][1] += Math.min(visit[i-1][0],visit[i-1][2]);
            visit[i][2] += Math.min(visit[i-1][1],visit[i-1][0]);
        }
        System.out.println(Math.min(visit[n-1][0],Math.min(visit[n-1][1],visit[n-1][2])));
    }
}