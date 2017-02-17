import java.util.Stack;

/**
 * Created by 蔡小木 on 2017/2/17 0017.
 */
public class Graph {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> theStack;

    public Graph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++)
            for (int x = 0; x < maxVertices; x++)
                theStack = new Stack<>();
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnivisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < vertexCount; j++)
            vertexList[j].visited = false;
    }

    public int getAdjUnivisitedVertex(int v) {
        for (int j = 0; j < vertexCount; j++)
            if (adjMatrix[v][j] == 1 && !vertexList[j].visited)
                return j;
        return -1;
    }
}
