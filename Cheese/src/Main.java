import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int Ccount, cnt;
    static int cheese = 0;
    static int[][] cMap;
    static boolean[][] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        makeCheese(); //Map 만들기
        while (Ccount != 0) { //치즈가 다 녹을때까지
            air(); //공기지나가며 치즈 녹임
            cnt++; //횟수
        }
        System.out.println(cnt);
        System.out.println(cheese);
    }

    public static void makeCheese() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cMap = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                cMap[i][j] = input.charAt(j) - '0';
                visit[i][j] = false;
                if (cMap[i][j] == 1) {
                    Ccount++;
                }//치즈 수 세기
            }
        }
    }

    public static void air() {
        int nextX, nextY;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cMap[i][j] == 0 && visit[i][j] == false) {
                    for (int k = 0; i < 4; i++) {// 4 방향 검사하며 가장자리 치즈지우기
                        nextX = i + dir[k][0];
                        nextY = j + dir[k][1];
                        if (-1 >= nextX || nextX >= n || -1 >= nextY || nextY >= m)
                            continue;
                        if (visit[nextX][nextY] == true) //이미 찾은 아파트일 수 있음 //나중에 지우고 다시해보기
                            continue;
                        if (cMap[nextX][nextY] == 1) {
                            cheese++;
                            cMap[nextX][nextY] = 0;
                            visit[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
        Ccount = Ccount - cheese;
    }
}
