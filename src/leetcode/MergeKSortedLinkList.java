package leetcode;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MergeKSortedLinkList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l2 == null) return l1;
        if(l1 == null) return l2;
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.val = l2.val;
                temp.next = l2.next;
                break;
            }
            if (l2 == null) {
                temp.val = l1.val;
                temp.next = l1.next;
                break;
            }
            if(l1.val < l2.val) {
                temp.val = l1.val;
                temp.next = new ListNode(0);
                l1 = l1.next;
            }else {
                temp.val = l2.val;
                temp.next = new ListNode(0);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        mergeTwoLists(l1,l2);
        testMinPathSum();
    }

    public static boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = cs.length; i < len; ++i) {
            char right = cs[i];
            if (stack.empty()) {
                stack.push(right);
            } else {
                char left = stack.peek();
                if (isMatch(left,right)) {
                    stack.pop();
                } else {
                    stack.push(right);
                }
            }
        }
        return stack.empty();
    }

    public static boolean isMatch(char left, char right) {
        if (left == '(' && right == ')') return true;
        if (left == '[' && right == ']') return true;
        if (left == '{' && right == '}') return true;
        return false;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, j = 0;
        int[] result = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a, b) -> b - a);
        for (int i = 0; i < k; ++i) {
            pq.add(nums[i]);
        }
        result[j++] = pq.peek() == null ? 0 : pq.peek();
        for (int i = k; i < len; ++i) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            result[j++] = pq.peek() == null ? 0 : pq.peek();
        }
        return result;
    }

    public static String reverseWords(String s) {
        String[] sa = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = sa.length - 1; i >= 0; --i) {
            if (sb.length() > 0) sb.append(" ");
            if (!sa[i].contains(" ")) sb.append(sa[i]);
        }
        return sb.toString().trim();
    }

    public static int myAtoi(String str) {
        boolean isPositive = true;
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        if (len == 0) return 0;
        char first = str.charAt(0);
        if (first == '-') {
            isPositive = false;
            sb.append("-");
        } else if (first == '+') {
            sb.append("+");
        } else if (first >= 48 && first <= 57) {
            sb.append("+").append(first);
        } else {
            return 0;
        }
        for (int i = 1; i < len; ++i) {
            first = str.charAt(i);
            if (first >= 48 && first <= 57) {
                sb.append(first);
            } else {
                break;
            }
        }
        if (sb.length() <= 1) return 0;
        try {
            return Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

    public boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    public static boolean isValid(char... cs) {
        int len = cs.length;
        Character[] chs = new Character[len];
        for (int i = 0; i < len; ++i) {
            if (cs[i] < 49 || cs[i] > 57) continue;
            if (chs[cs[i] - 49] != null) return false;
            chs[cs[i] - 49] = cs[i];
        }
        return true;
    }

    private Integer min = null;

    public int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        minPathSum(grid,0,0,w - 1,h - 1,0);
        return min == null ? 0 : min;
    }

    public void minPathSum(int[][] grid, int i, int j, int w, int h, int sum) {
        if (min != null && sum >= min) return;
        if (i == w && j == h) {
            sum += grid[j][i];
            if (min == null || min > sum) min = sum;
            return;
        }
        if (i > w || j > h) return;
        sum += grid[j][i];
        if (i < w) minPathSum(grid,i+1,j,w,h,sum);
        if (j < h) minPathSum(grid,i,j+1,w,h,sum);
    }

    public static void testMinPathSum() {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};
        MergeKSortedLinkList linkList = new MergeKSortedLinkList();
        System.out.println(linkList.minPathSum2(grid));
    }

    public int minPathSum2(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        for (int j = 0; j < h; ++j) {
            for (int i = 0; i < w; ++i) {
                if (i - 1 > -1 && j - 1 > -1) {
                    grid[j][i] += Math.min(grid[j][i-1], grid[j-1][i]);
                    continue;
                }
                if (i - 1 > -1) {
                    grid[j][i] += grid[j][i-1];
                    continue;
                }
                if (j - 1 > -1) {
                    grid[j][i] += grid[j-1][i];
                }
            }
        }
        return grid[h-1][w-1];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        return 0;
    }
}
