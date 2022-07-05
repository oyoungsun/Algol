import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sugar[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String []args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        sugar = new int[n+1];
        delivery(n);
    }
    public static void delivery(int n){
        sugar[4] = -1;
        sugar[3] = sugar[5] = 1;
        if(n>5){
            sugar[0] = sugar[1] = sugar[2]=-1;
            for(int i=6; i<n+1; i++){
                if(sugar[i-3]<0 && sugar[i-5]<0){
                    sugar[i]=-1;
                }
                else if(sugar[i-5]>0 && sugar[i-3]>0){ //3의 조합으로 이루어짐
                    sugar[i] = sugar[i-3] + 1;
                }
                else{ //3과 5의 조합으로 이루어짐
                    sugar[i] = Math.min(sugar[i-3], sugar[i-5]) + 1;
                }
            }
        }
        System.out.println(sugar[n]);
    }
}
