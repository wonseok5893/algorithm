package ProgrammersTest.level3;

public class 방문길이 {
    public int solution(String dirs) {
        int[][][]visited = new int[11][11][4];
        int startX = 5;
        int startY = 5;
        char[] chars = dirs.toCharArray();
        int count = 0;
        for (char c :chars){
            if(c=='U'){
                if(startY-1<0)continue;
                if(visited[startY-1][startX][2]==1){
                    startY--;
                    continue;
                }
                visited[startY][startX][0] =1;
                visited[startY-1][startX][2] =1;
                startY--;
                count++;
            }
            if(c=='R'){
                if(startX+1>10)continue;
                if(visited[startY][startX+1][3]==1){
                    startX++;
                    continue;
                }
                visited[startY][startX][1] =1;
                visited[startY][startX+1][3] =1;
                startX++;
                count++;
            }
            if(c=='D'){
                if(startY+1>10)continue;
                if(visited[startY+1][startX][0]==1){
                    startY++;
                    continue;
                }
                visited[startY][startX][2] =1;
                visited[startY+1][startX][0] =1;
                startY++;
                count++;
            }
            if(c=='L'){
                if(startX-1<0)continue;
                if(visited[startY][startX-1][1]==1){
                    startX--;
                    continue;
                }
                visited[startY][startX][3] =1;
                visited[startY][startX-1][1] =1;
                startX--;
                count++;
            }
        }
        return count;

    }
}
