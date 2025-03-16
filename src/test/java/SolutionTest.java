import LeetCode.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.TreeNode;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {
    @Parameterized.Parameter(0)
    public String s1;
    @Parameterized.Parameter(1)
    public String s2;
    @Parameterized.Parameter(2)
    public boolean ex;


    @Parameterized.Parameters
    public static Collection<Object[]> useCases() {
        return Arrays.asList(new Object[][]{
                {"ky","ainwkckifykxlribaypk",true}
        });
    }

    @Test
    public void testSolveNQueens() {
        Solution solution = new Solution();
        boolean result = solution.checkInclusion(s1,s2);
        assertEquals(ex, result); // 使用 JUnit 的 assertEquals 方法
    }
}
