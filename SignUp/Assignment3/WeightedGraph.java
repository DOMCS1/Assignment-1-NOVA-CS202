package SignUp.Assignment3;

/**
 * Created by Pratyush Gupta on 7/22/2017.
 */
public class WeightedGraph<E>
{
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 60;
    private int numVertices;
    private int maxVertices;
    private E[] vertices;
    private int[][] edges;
    private boolean[] marks;
    public WeightedGraph()
    {
        numVertices = 0;
        maxVertices = DEFCAP;
        vertices = (E[]) new Object[DEFCAP];
        marks = new boolean[DEFCAP];
        edges = new int[DEFCAP][DEFCAP];
    }

    public WeightedGraph(int maxV)
    {
        numVertices = 0;
        maxVertices = maxV;
        vertices = (E[]) new Object[maxV];
        marks = new boolean[maxV];
        edges = new int[maxV][maxV];
    }


    public boolean isEmpty()
    {
        return numVertices == 0;
    }

    public boolean isFull()
    {
        return numVertices>=maxVertices;
    }

    public void addVertex(E vertex)

    {
        vertices[numVertices] = vertex;
        for (int index = 0; index < numVertices; index++)
        {
            edges[numVertices][index] = NULL_EDGE;
            edges[index][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }

//    public boolean hasVertex(E vertex)
//    {
//    }


    private int indexIs(E vertex)
    {
        int index = 0;
        while (!vertex.equals(vertices[index]))
            index++;
        return index;
    }

    public void addEdge(E fromVertex, E toVertex, int weight)
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        edges[row][column] = weight;
    }

    public int weightIs(E fromVertex, E toVertex)
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        return edges[row][column];
    }


    public boolean edgeExists(E vertex1, E vertex2)

    {
        return (edges[indexIs(vertex1)][indexIs(vertex2)] != NULL_EDGE);
    }

    public boolean removeEdge(E vertex1, E vertex2)
    {
        boolean existed = edgeExists(vertex1, vertex2);
        edges[indexIs(vertex1)][indexIs(vertex2)] = NULL_EDGE;
        return existed;
    }

}