import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        int [] high;
        int nodeNum = Integer.parseInt(br.readLine());
        high = new A[nodeNum];
        for(int i=0; i<nodeNum; i++) {
            high[i] = new ArrayList[nodeNum];
            high[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        //1 층 구하기

    }

}
/*    1. 층 총 수 구하기;
    층 == 1
        얼리어댑터 : 1
    층 == 2
        얼리어댑터 : 1 밑에 노드 수
    층>2
        0. 1은 얼리어댑터로 넣는다
        1. 자식이 있으면 얼리어댑터
        2. 얼리어댑터 중 다시 검사
            얼리어댑터인데 부모랑 모든 자식이 얼리어댑터이면 본인은 아님.
        3. 1은 자식이 모두 얼리어댑터이면 본인은 아님.
 */
