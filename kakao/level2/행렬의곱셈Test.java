package kakao.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 행렬의곱셈Test {
    @Test
    void solutionTest(){
        행렬의곱셈 instance = new 행렬의곱셈();
        instance.solution(new int[][]{{1,2,1},{1,2,3},{2,1,2}},new int[][]{{1,2,3,4},{1,2,3,4},{1,2,3,4}});
    }

}