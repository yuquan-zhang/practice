package algorithms.sort;

import java.util.LinkedList;

public class TopologicalSorting {

    private static class Graph {
        private int v; // 顶点的个数
        private LinkedList<Integer>[] adj; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            adj[s].add(t); // s 先于 t, s -> t;
        }

        public void topoSortByKahn() {
            int[] inDegree = new int[v]; // 统计每个顶点的入度
            for (int i = 0; i < v; ++i) {
                for (int j = 0, len = adj[i].size(); j < len; ++j) {
                    int w = adj[i].get(j);
                    inDegree[w]++;
                }
            }

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; ++i) {
                if (inDegree[i] == 0) queue.add(i);
            }

            while (!queue.isEmpty()) {
                int i = queue.remove();
                System.out.println("->" + i);
                for (int j = 0, len = adj[i].size(); j < len; ++j) {
                    int k = adj[i].get(j);
                    inDegree[k]--;
                    if (inDegree[k] == 0) queue.add(k);
                }
            }
        }
    }

}
