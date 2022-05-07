import java.io.IOException;

public class Main {
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        makeApart();
        dfs();
    }

    private static void makeApart() {

    }

    private static void dfs() {
        fot(next :graph[node]){
            아파트찾기
            if (!visit[next]) {
                if next == 1 { //aprt 찾기
                    아파트+1
                    visit next;
                    stack.add(pop);
                    집의 수+1
                    while (stack Empty) //4방향 모두 visit||0
                    next = pop.stack
                    for nextt = next + dir
                    if visit
                            pass
                    visit nextt
                    if 0
                    pass
                    //if(nextt==1)
                    stack.add(nextt);
                    집의 수+1
                    apartNum.add(단지수);
                    return;
                }
                dfs(next);

            }
        }
    }

}