import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tools.KPM;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class KpmTest {

    private String matchStr;
    private String patternStr;
    private int index;

    public KpmTest(String matchStr, String patternStr, int index) {
        this.matchStr = matchStr;
        this.patternStr = patternStr;
        this.index = index;
    }

    @Parameters
    public static Collection<Object[]> provideTestCases() {
        return Arrays.asList(new Object[][] {
                { "abcdefg", "ab", 0 },
                { "abcdefg", "bc", 1 },
                { "abcdefg", "cd", 2 },
                { "abcdefg", "efg", 4 },
                { "abcdefg", "xyz", -1 }
        });
    }

    @Test
    public void testKpm() {
        KPM kpm = new KPM();
        int result = kpm.kpm(matchStr.toCharArray(), patternStr.toCharArray());
        assert result == index : "Expected " + index + " but got " + result;
    }
}
