import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //1로 만들기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int check[];

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        check = new int[x+1];

        if (x == 1) {
            System.out.println(0);
            return;
        } else if (x == 2 || x == 3) {
            System.out.println(1);
            return;
        } else {
            check[1] = 0;
            check[2] = 1;
            check[3] = 1;
            for (int i = 4; i < x + 1; i++) {
                if (i % 6== 0) {
                    check[i] = Math.min(check[i-1],Math.min(check[i / 3], check[i / 2]))+1;
                    //미칭 i-1은머고 나 혹시 빠가가??
                }
                else if (i % 3 == 0) {check[i] = Math.min(check[i-1],check[i / 3]) + 1;}
                else if (i % 2 == 0) {check[i] = Math.min(check[i-1],check[i / 2]) + 1;}
                else {
                    check[i] = check[i - 1] + 1;
                }
            }
        }
        System.out.println(check[x]);
        return;
    }
}

