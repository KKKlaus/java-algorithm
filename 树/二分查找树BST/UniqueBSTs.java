public class UniqueBSTs {

     // BST 与 DP的结合
     // 解析： https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1; G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
