import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = greedy(N);
        System.out.println(count);
        return;
    }
    public static int greedy(int N){
        int num = N;
        int cnt=0;
        while(true){
            if(num % 5 ==0) {
                cnt += num / 5;
                break;
            }
            else if(num < 0){
                cnt = -1;
            }
            num = num - 3;
            cnt++;
        }
        return cnt; //입력값이 3부터 주어진다
    }
}
