import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List arr = new ArrayList();
    public static void main(String args[]) throws IOException {
        int sum1=0;
        int sum2=0;
        boolean p = true;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "-");
        while(st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        // - 나올떄까지 +에 더하기
        st = new StringTokenizer((String) arr.get(0),"+");
        while(st.hasMoreTokens()) {
            sum1 += Integer.parseInt(st.nextToken());
        }
        // - 만나면 -에 더하기
        for(int i=1; i<arr.size(); i++) {
            st = new StringTokenizer((String) arr.get(i),"+");
            while(st.hasMoreTokens()) {
                sum2 += Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(sum1-sum2);
    }
}
