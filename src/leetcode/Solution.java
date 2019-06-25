package leetcode;

import java.io.Serializable;
import java.util.*;

class Solution implements Serializable {

    private static final long serialVersionUID = -3342338195983809309L;
    private Map<Character, Character[]> map = new HashMap<>();

    public Solution() {
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        for (Map.Entry entry : map.entrySet()) {

        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        char[] numbers = digits.toCharArray();
        letterCombination(strings,"",numbers,0);
        return strings;
    }

    public void letterCombination(List<String> strings,String s, char[] numbers, int i) {
        if(i >= numbers.length) {
            if(s.length() > 0) strings.add(s);
            return;
        }
        Character[] letters = map.get(numbers[i]);
        for (Character c : letters) {
            letterCombination(strings,s + c,numbers,i+1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseBits(-2);
//        System.out.println(solution.largestNumber(new int[]{1,2,3,4,5,0}));
//        System.out.println(solution.addBinary("101","1"));
//        solution.levelOrderBottom();
//        System.out.println((int)'0');
//        System.out.println((int)'9');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println(solution.letterCombinations(""));
//        int[] ints = new int[]{1,2,3};
//        ArrayList<Integer> integers = new ArrayList<>();
//        for (int i = 0; i < ints.length; ++i) {
//            integers.add(i);
//        }
//        List<List<Integer>> res = new ArrayList<>(acceptInts(integers, ints));
    }

    public static Set<List<Integer>> acceptInts(ArrayList<Integer> integers, int[] ints) {
        Set<List<Integer>> res = new HashSet<>();
        if (integers.size() == 1) {
            int i = ints[integers.get(0)];
            integers.clear();
            integers.add(i);
            res.add(integers);
            return res;
        }
        for (Integer i : integers) {
            ArrayList<Integer> temp = (ArrayList<Integer>)integers.clone();
            temp.remove(i);
            Set<List<Integer>> tr = acceptInts(temp,ints);
            for (List<Integer> list : tr) {
                list.add(0,ints[i]);
                res.add(list);
            }
        }
        return res;
    }

    public String addBinary(String a, String b) {
        int al = a.length(), bl = b.length(), len = 0;
        String head = "";
        if (al > bl) {
            head = a.substring(0,al - bl);
            a = a.substring(al - bl, al);
            len = bl;
        } else {
            head = b.substring(0,bl - al);
            b = b.substring(bl - al, bl);
            len = al;
        }
        StringBuilder sb = new StringBuilder();
        boolean isTwo = false;
        for (int i = len - 1; i >= 0; --i) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (isTwo) {
                    sb.insert(0,"1");
                } else {
                    sb.insert(0,"0");
                }
                isTwo = false;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (isTwo) {
                    sb.insert(0,"1");
                } else {
                    sb.insert(0,"0");
                }
                isTwo = true;
            } else {
                if (isTwo) {
                    sb.insert(0,"0");
                } else {
                    sb.insert(0,"1");
                }
            }
        }

        for (int j = head.length() - 1; j >= 0; --j) {
            if (head.charAt(j) == '0') {
                if (isTwo) {
                    sb.insert(0,"1");
                } else {
                    sb.insert(0,"0");
                }
                isTwo = false;
            } else if (head.charAt(j) == '1') {
                if (isTwo) {
                    sb.insert(0,"0");
                } else {
                    sb.insert(0,"1");
                }
            }
        }
        if (isTwo) sb.insert(0,"1");
        return sb.toString();
    }

    public void levelOrderBottom() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
        reverseList(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void reverseList(List<Integer> list) {
        for (int i = 0, len = list.size(), mid = len / 2; i < mid; ++i) {
            Integer temp = list.get(i);
            list.set(i,list.get(len - i - 1));
            list.set(len - i - 1,temp);
        }
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) return "";
        String[] sa = new String[len];
        for (int i = 0; i < len; ++i) {
            sa[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sa,(a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        System.out.println(Arrays.toString(sa));
        if (sa[len - 1].startsWith("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (String s : sa) {
            res.append(s);
        }
        return res.toString();
    }

    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-n-1));
        return -n;
    }

}
