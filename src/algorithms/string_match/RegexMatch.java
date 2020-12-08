package algorithms.string_match;

/**
 * @author zhangyong created on 2020/6/28
 **/
public class RegexMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("abc","abc"));
        System.out.println(isMatch("abc","ab*"));
        System.out.println(isMatch("abc","ab."));
        System.out.println(isMatch("abc","abc*"));
        System.out.println(isMatch("aaa","a*"));
        System.out.println(isMatch("aaa","*"));
    }

    public static boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int sl = sc.length, pl = pc.length;
        boolean[][] state = new boolean[sl+1][pl+1];
        state[0][0] = true;
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (pc[j-1] == '*') {
                    state[i][j] = j >= 2 && state[i][j-2];
                    if (isMatch(sc,pc,i,j-1)) {
                        state[i][j] = state[i][j] || state[i-1][j];
                    }
                } else {
                    if (isMatch(sc,pc,i,j)) {
                        state[i][j] = state[i-1][j-1];
                    }
                }
            }
        }
        return state[sl][pl];
    }

    public static boolean isMatch(char[] sc, char[] pc, int si, int pi) {
        if (si == 0 || pi == 0) return false;
        if (pc[pi-1] == '.') return true;
        return pc[pi-1] == sc[si-1];
    }


}
