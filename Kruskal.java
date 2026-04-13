
import java.util.Arrays;

class FloydWarshall {
    static final int INF = 99999;

    public static void ejecutar() {
        int[][] dist = {
            {0,10,INF,INF,3},
            {INF,0,2,INF,4},
            {INF,INF,0,9,INF},
            {INF,INF,7,0,INF},
            {INF,1,8,2,0}
        };

        int V = 5;

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int[] fila : dist) {
            System.out.println(Arrays.toString(fila));
        }

        System.out.println("Camino minimo 0 -> 3: 0 -> 4 -> 3");
    }
}