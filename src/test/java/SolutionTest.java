import LeetCode.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int n;
    private List<List<String>> expected;

    public SolutionTest(int n, List<List<String>> expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> useCases() {
        return Arrays.asList(new Object[][]{
                {4, Arrays.asList(
                        Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                        Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
                )}
        });
    }

    @Test
    public void testSolveNQueens() {
        Solution solution = new Solution();
        List<List<String>> result = solution.solveNQueens(n);
        assertEquals(expected, result); // 使用 JUnit 的 assertEquals 方法
    }
}
