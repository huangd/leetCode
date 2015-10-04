package leetcode;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 12:19 AM
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        String rA = new StringBuilder(a).reverse().toString();
        String rB = new StringBuilder(b).reverse().toString();
        StringBuilder ab = new StringBuilder();
        int i = 0;
        boolean isCarryOver = false;
        for(; i < a.length() || i < b.length(); i++) {
            int rAi = i < rA.length() ? new Integer(rA.charAt(i) + "") : 0;
            int rBi = i < rB.length() ? new Integer(rB.charAt(i) + "") : 0;
            int sum  = isCarryOver ? rAi + rBi + 1 : rAi + rBi;
            if (sum == 1 || sum == 0) {
                ab.append(sum);
                isCarryOver = false;
            } else {
                ab.append(sum - 2);
                isCarryOver = true;
            }
        }
        if (isCarryOver) {
            ab.append(1);
        }
        return ab.reverse().toString();
    }
}
