package chapter2;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/24
 */
public class Problem10 {
    public int resolve(int n) {
        if (n == 0 || n == 1) return 1;
        int prepre = 1;
        int pre = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = prepre + pre;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }

    int[] dp;

    private int resolveDGPrivate(int n) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] > 0) return dp[n];
        int n1 = resolveDGPrivate(n - 1);
        int n2 = resolveDGPrivate(n - 2);
        dp[n - 1] = n1;
        dp[n - 2] = n2;
        return n1 + n2;
    }
    public int resolveDG(int n){
        dp=new int[n+1];
        return resolveDGPrivate(n);
    }

    public static void main(String[] args) {
        Problem10 p10 = new Problem10();
        int n = 10;
        System.out.println(p10.resolve(n));
        System.out.println(p10.resolveDG(n));
    }
}
