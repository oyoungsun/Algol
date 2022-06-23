import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int arr[];
    static int time=0;
    static int sum=0;
    public static void main(String args[]) throws IOException {

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        greedy();
        System.out.println(sum);
        return;
    }
    public static void greedy(){
        for(int i=0; i<N; i++){
            time = time + arr[i];
            sum +=time;
        }
        return;
    }
}
