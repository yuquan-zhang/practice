package algorithms.string_match;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong created on 2020/10/15
 **/
public class DFA {
    private final String[] sensitives = {"日本人","日本","黄色","色情","一夜情","暴力"};

    private final Map<Character, TrieNode> tree = new HashMap<>();

    public class TrieNode {
        public char data;
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    private void init() {
        for (String s : sensitives) {
            Map<Character, TrieNode> nodeMap = tree;
            TrieNode node = null;
            for (char c : s.toCharArray()) {
                node = nodeMap.get(c);
                if (node == null) {
                    node = new TrieNode(c);
                    nodeMap.put(c,node);
                }
                nodeMap = node.children;
            }
            if (node != null) {
                node.isEndingChar = true;
            }
        }
    }

    private int checkSensitive(String s, int beginIndex) {
        int lengthCount = 0;
        int maxLength = 0;
        Map<Character, TrieNode> trieNode = tree;
        for (int i = beginIndex, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (' ' == c) { // 过滤掉空字符
                if (i == beginIndex) break;
                lengthCount++;
                continue;
            }
            TrieNode node = trieNode.get(c);
            if (node != null) {
                lengthCount++;
                if (node.isEndingChar) {
                    maxLength = Math.max(maxLength,lengthCount);
                }
                trieNode = node.children;
            } else {
                break;
            }
        }
        return maxLength;
    }

    private boolean hasSensitive(String s) {
        for (int i = 0, len = s.length(); i < len; i++) {
            int maxLen = checkSensitive(s, i);
            if (maxLen > 0) return true;
        }
        return false;
    }

    private String replaceSensitive(String s) {
        char[] chars = s.toCharArray();
        int i = 0, len = chars.length;
        while (i < len) {
            int maxLen = checkSensitive(s, i);
            if (maxLen > 0) {
                for (int j = i; j < i + maxLen; j++) {
                    chars[j] = '*';
                }
                i += maxLen;
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        DFA dfa = new DFA();
        dfa.init();
//        System.out.println(dfa.hasSensitive("这是一个有色 情的故事"));
        System.out.println(dfa.replaceSensitive("这是一个    有色 情暴力   的故事，话说有一个日 本   人，他出生在日 本的一个小山村，村里有一个漂亮姑娘，他喜欢那个姑娘，想和她搞一夜情。"));
    }
}
