package algorithms.thought.dynamic.programming;

public class YanHuiTriangle {

    public static void main(String[] args) {
        int[][] triangle = {{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};
        System.out.println(minPath(triangle));

        int[][] map = {{1,3,5,9,23},{2,1,3,4,98},{5,2,6,7,45},{6,8,4,3,24},{16,28,34,53,24}};
        long start = System.nanoTime();
        System.out.println(minDist(map));
        long end = System.nanoTime();
        System.out.println(end - start);
        start = System.nanoTime();
        System.out.println(minDist2(map));
        end = System.nanoTime();
        System.out.println(end - start);

        int[] vs = {7,3,5};
        System.out.println(chargeCoin(vs,18));
    }

    private static int minPath(int[][] triangle) {
        int minPath = Integer.MAX_VALUE;
        int len = triangle.length;
        int[][] status = new int[len][len];
        status[0][0] = triangle[0][0];
        for (int i = 1; i < len; ++i) {
            for (int j = 0, jl = triangle[i].length; j < jl; ++j) {
                if (status[i - 1][j] > 0) status[i][j] = status[i-1][j] + triangle[i][j];
                if (j > 0 && status[i-1][j-1] + triangle[i][j] > status[i][j]) {
                    status[i][j] = status[i-1][j-1] + triangle[i][j];
                }
            }
        }
        for (int i = 0; i < len; ++i) {
            if (status[len - 1][i] < minPath) minPath = status[len - 1][i];
        }
        return minPath;
    }

    private static int minDist(int[][] map) {
        return minDist(map,map.length-1,map.length-1);
    }

    private static int minDist(int[][] map, int row, int col) {
        if (row == 0 && col == 0) return map[row][col];
        if (row == 0 && col > 0) return map[row][col] + minDist(map,row, col-1);
        if (row > 0 && col == 0) return map[row][col] + minDist(map,row-1, col);
        return map[row][col] + Math.min(minDist(map,row, col-1),minDist(map,row-1, col));
    }

    private static int minDist2(int[][] map) {
        int len = map.length;
        int[][] status = new int[len][len];
        status[0][0] = map[0][0];
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {
                status[i-j][j] = Integer.MAX_VALUE;
                if (i - j > 0) status[i-j][j] = map[i-j][j] + status[i-j-1][j];
                if (j > 0 && map[i-j][j] + status[i-j][j-1] < status[i-j][j]) {
                    status[i-j][j] = map[i-j][j] + status[i-j][j-1];
                }
            }
        }
        int s = 2 * (len - 1);
        for (int i = len; i <= s; ++i) {
            for (int j = i-len + 1; j < len; ++j) {
                status[i-j][j] = map[i-j][j] + status[i-j-1][j];
                if (map[i-j][j] + status[i-j][j-1] < status[i-j][j]) {
                    status[i-j][j] = map[i-j][j] + status[i-j][j-1];
                }
            }
        }
        return status[len-1][len-1];
    }

    private static int chargeCoin(int[] vs, int w) {
        int coins = 0;
        boolean[] status = new boolean[w + 1];
        int len = vs.length;
        for (int i = 0; i < len; ++i) {
            if (vs[i] <= w) status[vs[i]] = true;
        }
        ++coins;
        while (!status[w]) {
            boolean hasChange = false;
            boolean[] cs = new boolean[w + 1];
            for (int i = 0; i < len; ++i) {
                for (int j = w; j > 0; --j) {
                    if (status[j] && j + vs[i] <= w && !status[j + vs[i]]) {
                        hasChange = true;
                        cs[j + vs[i]] = true;
                    }
                }
            }
            status = cs;
            ++coins;
            if (!hasChange) break;

        }
        if (!status[w]) return -1;
        return coins;
    }
}
