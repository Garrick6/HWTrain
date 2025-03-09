package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] booleans = new boolean[n][n];
        return dfs(n, booleans, 0, new Stack<>(), new ArrayList<>());
    }

    public List<List<String>> dfs(int n, boolean[][] booleans, int index, Stack<String> curr, List<List<String>> res) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return null;
        }
        for (int i = 0; i < n; i++) {
            if (check(n, booleans, index, i)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(".".repeat(n));
            sb.replace(i, i + 1, "Q");
            curr.push(sb.toString());
            booleans[index][i] = true;
            dfs(n, booleans, index + 1, curr, res);
            booleans[index][i] = false;
            curr.pop();
        }
        return res;
    }

    public boolean check(int n, boolean[][] booleans, int x, int y) {
        //同一列
        for (int i = x; i >= 0; i--) {
            if (booleans[i][y]) {
                return true;
            }
        }

        //斜着
        for (int i = 1; i <= x; i++) {
            if (y - i < 0) break;
            if (booleans[x - i][y - i]) {
                return true;
            }
        }

        //斜着
        for (int i = 1; i <= x; i++) {
            if (y + i >= n) break;
            if (booleans[x - i][y + i]) {
                return true;
            }
        }
        return false;
    }
}