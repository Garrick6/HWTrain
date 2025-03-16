import HWOJ.CheckConstraints;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HWOJTest {
    @Parameterized.Parameter(0)
    public String in;
    @Parameterized.Parameter(1)
    public String ex;

    @Parameterized.Parameters
    public static Collection<Object[]> initialize() {
        return Arrays.asList(new Object[][]{
                {"2.3,3,5.6,7.6,0;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<="
                        , "false 458"},
                {"2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<="
                        , "false 758"}
        });
    }

    @Test
    public void test() {
        CheckConstraints constraints = new CheckConstraints();
        String res = constraints.checkConstraints(in);
        Assert.assertEquals(ex, res);
    }
}
