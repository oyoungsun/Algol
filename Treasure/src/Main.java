import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer A[];
    static Integer B[];
    public static void main(String args[]) throws IOException {
        int max=0;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new Integer[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = new Integer[N];
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        //1. A를 작은 수 부터 정렬하기
        Arrays.sort(A);
        //2. B요소 순위 value 정하기
        //max값의 index찾기
        //B 정렬하기 큰수부터
        Arrays.sort(B, Collections.reverseOrder());
        sum();
        return;
    }

    public static void sum(){
        int sum=0;
        for(int i=0; i<N; i++){
            sum += A[i] * B[i];
        }
        System.out.println(sum);
    }
}
