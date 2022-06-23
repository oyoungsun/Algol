import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int d;
    static int money;
    static int count=0;
    static int coin[];

    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        coin = new int[d];
        for(int i = 0; i < d; i++) {
            coin[i] =  Integer.parseInt(br.readLine()); // 참고한줄
        }
        greedy();
        return;
    }
    public static void greedy(){
       for(int i=d-1; i>=0; i--) {
            if (money < coin[i]) {
                continue;
            }
            count += money / coin[i];
            money = money %coin[i];
        }
        System.out.println(count);
        return;
    }
}
