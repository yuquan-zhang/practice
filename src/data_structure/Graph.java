package data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int n; // 定点的个数, the number of vertex
    private LinkedList<Integer>[] adjs; // 邻接表, adjacent table

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        this.n = n;
        adjs = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            adjs[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adjs[s].add(t);
        adjs[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[n];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] pre = new int[n];
        for (int i = 0; i < n; ++i) {
            pre[i] = -1;
        }
        while (queue.size() > 0) {
            int w = queue.poll();
            for (int i = 0, len = adjs[w].size(); i < len; ++i) {
                int q = adjs[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        print(pre, s, t);
                        return;
                    }
                    queue.add(q);
                    visited[q] = true;
                }
            }
        }
    }

    private void print(int[] pre, int s, int t) { // 递归打印 s 到 t 的路径
        if (pre[t] != -1 && t != s) {
            print(pre, s, pre[t]);
        }
        System.out.print(t + " ");
    }

    public void dfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        recurDfs(s, t, visited, stack);
        String path = "";
        while (!stack.empty()) {
            path = stack.pop() + " " +  path;
        }
        System.out.println(path);
    }

    private void recurDfs(int s, int t, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;
        stack.push(s);
        if (s == t) return;
        for (int i = 0, len = adjs[s].size(); i < len; ++i) {
            int q = adjs[s].get(i);
            if (visited[q]) continue;
            recurDfs(q, t, visited, stack);
            if (stack.peek() == t) return;
        }
        stack.pop();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.bfs(0, 7);
        System.out.println();
        graph.dfs(0,7);
    }

}
