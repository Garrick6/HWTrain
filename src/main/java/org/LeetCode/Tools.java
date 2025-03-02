package org.LeetCode;

public class Tools {
    /**
     * 使用KMP算法查找模式字符串在匹配字符串中的位置
     *
     * @param matchedStr 匹配字符串，即我们要在其中查找模式字符串的字符串
     * @param patternStr 模式字符串，即我们要在匹配字符串中查找的字符串
     * @return 如果找到模式字符串，则返回其在匹配字符串中首次出现的位置；如果未找到，则返回-1
     */
    public int KPM(char[] matchedStr, char[] patternStr) {
        int[] next = new int[patternStr.length];
        int j = 0;
        for (int i = 1; i < patternStr.length; i++) {
            while (j > 0 && patternStr[i] != patternStr[j]) j = next[j - 1];
            if (patternStr[i] == patternStr[j]) j++;
            next[i] = j;
        }
        j = 0;
        for (int i = 0; i < patternStr.length; i++) {
            while (j > 0 && matchedStr[i] != patternStr[j]) j = next[j - 1];
            if (matchedStr[i] == patternStr[j]) j++;
            if (j == patternStr.length) return i - patternStr.length + 1;
        }
        return -1;
    }
}
