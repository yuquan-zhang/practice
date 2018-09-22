package data_structure;

public class Graph {
    private class Vertex {
        char label;
        boolean visited;
    }

    private Vertex[] vertices = new Vertex[5];
    private int[][] adjMatrix = new int[5][5];
    private int vertexCount = 0;

    public void addVertex(char label) {
        Vertex vertex = new Vertex();
        vertex.label = label;
        vertex.visited = false;
        vertices[vertexCount++] = vertex;
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int vertexIndex) {
        System.out.println(vertices[vertexIndex].label);
    }

    public int getAdjUnvisitedVertex(int vertexIndex) {
        int i;
        for(i = 0; i < vertexCount; i++) {
            if(adjMatrix[vertexIndex][i] == 1 && !vertices[i].visited) {
                return i;
            }
        }
        return -1;
    }

    public void depthFirstSearch() {
        StackDemo<Integer> stack = new StackDemo<>(5);
        vertices[0].visited = true;
        displayVertex(0);
        stack.push(0);

        while(!stack.isEmpty()) {
            int unvisitedVertex = getAdjUnvisitedVertex(stack.peek());
            if(unvisitedVertex != -1) {
                vertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                stack.push(unvisitedVertex);
            }else{
                stack.pop();
            }
        }
        int i;
        for(i = 0; i < vertexCount; i++) {
            vertices[i].visited = false;
        }
    }

    public void breadthFirstSearch() {
        QueueDemo<Integer> queue = new QueueDemo<>(5);
        vertices[0].visited = true;
        displayVertex(0);
        queue.enQueue(0);

        while(!queue.isEmpty()) {
            int unvisitedVertex = getAdjUnvisitedVertex(queue.peek());
            if(unvisitedVertex != -1) {
                vertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                queue.enQueue(unvisitedVertex);
            }else{
                queue.deQueue();
            }
        }
        int i;
        for(i = 0; i < vertexCount; i++) {
            vertices[i].visited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('S');
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        System.out.println("Depth First Search: ");
        graph.depthFirstSearch();
        System.out.println("Breadth First Search: ");
        graph.breadthFirstSearch();
    }
}
