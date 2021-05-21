package leetcode.leetcode.editor.cn;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 638 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {
    private final int[][] adds = new int[10][10];
    private final int[][] mul = new int[10][10];
    private final String[] zs = {"0000000000","0","00","000","0000","00000",
            "000000","0000000","00000000","000000000"};
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                adds[i][j] = i + j;
                mul[i][j] = i * j;
            }
        }
    }
    public String multiply(String num1, String num2) {
        if (num1.length() < 1 || num2.length()  < 1) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        List<String> adds = new ArrayList<>();
        int l1 = num1.length();
        for (int i = l1 - 1; i >= 0; i--) {
            StringBuilder prod = new StringBuilder(multiply(num2, num1.charAt(i)));
            int zeros = l1 - 1  - i;
            while (zeros > 0) {
                if (zeros >= 10) {
                    prod.append(zs[0]);
                    zeros -= zs.length;
                } else {
                    prod.append(zs[zeros]);
                    zeros = 0;
                }
            }
            adds.add(prod.toString());
        }
        String ans = adds.get(0);
        for (int i = 1; i < adds.size(); i++) {
            ans = add(ans, adds.get(i));
        }
        return ans;
    }

    private String multiply(String num1, char num2) {
        if (num1.equals("0") || num2 == '0') return "0";
        StringBuilder ans = new StringBuilder();
        int len = num1.length();
        char carry = '0';
        for (int i = len-1; i >= 0; i--) {
            String prod = "" + mul[num1.charAt(i) - 48][num2 - 48];
            String sum = add(prod, "" + carry);
            char tail = sum.charAt(sum.length() - 1);
            ans.append(tail);
            if (sum.length() > 1) {
                carry = sum.charAt(0);
            } else {
                carry = '0';
            }
        }
        if (carry != '0') ans.append(carry);
        return ans.reverse().toString();
    }

    private String add(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int l1 = num1.length(), l2 = num2.length();
        char carry = '0';
        while (l1 > 0 && l2 > 0) {
            l1--;
            l2--;
            String sum = add(num1.charAt(l1), num2.charAt(l2));
            String sum2 = sum;
            char ch = sum.charAt(sum.length() - 1);
            if (carry != '0') {
                sum2 = add(carry, ch);
            }
            if (sum.length() > 1 || sum2.length() > 1) {
                carry = '1';
            } else {
                carry = '0';
            }
            ans.append(sum2.charAt(sum2.length() - 1));
        }
        while (l1 > 0) {
            l1--;
            if (carry != '0') {
                String sum = add(num1.charAt(l1), carry);
                if (sum.length() > 1) {
                    carry = '1';
                } else {
                    carry = '0';
                }
                ans.append(sum.charAt(sum.length() - 1));
            } else {
                ans.append(num1.charAt(l1));
            }
        }

        while (l2 > 0) {
            l2--;
            if (carry != '0') {
                String sum = add(num2.charAt(l2), carry);
                if (sum.length() > 1) {
                    carry = '1';
                } else {
                    carry = '0';
                }
                ans.append(sum.charAt(sum.length() - 1));
            } else {
                ans.append(num2.charAt(l2));
            }
        }
        if (carry != '0') ans.append(carry);
        return ans.reverse().toString();
    }

    private String add(char num1, char num2) {
        return "" + adds[num1 - 48][num2 - 48];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
