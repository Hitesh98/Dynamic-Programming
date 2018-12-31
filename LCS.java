public class LCS {

    private char[] findLCS(String s1, String s2) {

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int[][] lcsTable = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                } else if (X[i-1] == Y[j-1]) {
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;
                } else {
                    lcsTable[i][j] = max(lcsTable[i-1][j], lcsTable[i][j-1]);
                }
            }
        }
        char[] commonArray = new char[lcsTable[m][n]];
        int index = lcsTable[m][n]-1;
        int i = m, j = n;
        while (i != 0 && j != 0) {
            if (lcsTable[i][j] == lcsTable[i-1][j]) {
                i = i-1;
            } else if (lcsTable[i][j] == lcsTable[i][j-1]) {
                j = j - 1;
            } else {
                commonArray[index--] = X[i - 1];
                i = i - 1;
                j = j - 1;
            }
        }
        return commonArray;
    }

    private static int max(int a, int b) {
        return (a > b)? a : b;
    }

    public static void main(String[] args) {
        LCS lcsobj = new LCS();
        String s1 = "AGGTAB";
        String s2 = "AGGTAB";
        char[] result = lcsobj.findLCS(s1, s2);
        for (char c : result) {
            System.out.print(c);
        }
    }

}
