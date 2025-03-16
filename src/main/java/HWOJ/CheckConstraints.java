package HWOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class CheckConstraints {
    double[][] nums;
    int[] multiplier;
    double[] ans;
    String[] jude;
    double[] rel_ans = new double[3];

    public String checkConstraints(String s) {
        in(s);
        return (isTrue() ? "true" : "false") + " " + maxDiff();
    }

    public void in(String s) {
        String[] strings = s.split(";");
        nums = Arrays.stream(strings).limit(3)
                .map(a -> Arrays.stream(a.split(",")).mapToDouble(Double::parseDouble).toArray())
                .toArray(double[][]::new);
        multiplier = Arrays.stream(strings).skip(3).limit(1)
                .flatMapToInt(a -> Arrays.stream(a.split(",")).mapToInt(Integer::parseInt))
                .toArray();
        ans = Arrays.stream(strings).skip(4).limit(1)
                .flatMapToDouble(a -> Arrays.stream(a.split(",")).mapToDouble(Double::parseDouble))
                .toArray();
        jude = Arrays.stream(strings)
                .skip(5)
                .flatMap(a -> Arrays.stream(a.split(",")))
                .toArray(String[]::new);
    }

    private boolean isTrue() {
        int n = nums[0].length;
        for (int i = 0; i < 3; i++) {
            double res = 0;
            for (int j = 0; j < n; j++) {
                res += nums[i][j] * multiplier[j];
            }
            rel_ans[i] = res;
        }

        for (int i = 0; i < 3; i++) {
            String check = jude[i];
            switch (check) {
                case ">=":
                    if (rel_ans[i] < ans[i]) return false;
                    break;
                case "<=":
                    if (rel_ans[i] > ans[i]) return false;
                    break;
                case "==":
                    if (rel_ans[i] != ans[i]) return false;
                    break;
                case "<":
                    if (rel_ans[i] >= ans[i]) return false;
                    break;
                case ">":
                    if (rel_ans[i] <= ans[i]) return false;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected operator: " + check);
            }
        }
        return true;
    }

    private int maxDiff() {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = (int) Math.max(max, rel_ans[i] - ans[i]);
        }
        return max;
    }
}
