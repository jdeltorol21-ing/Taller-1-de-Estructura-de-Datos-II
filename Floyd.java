
import java.util.Arrays;

class Dijkstra {
    static int V = 5;

    public static void ejecutar() {
        int[][] g = {
            {0,10,0,0,3},
            {0,0,2,0,4},
            {0,0,0,9,0},
            {0,0,7,0,0},
            {0,1,8,2,0}
        };

        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        int[] padre = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++)
                if (!vis[j] && (u == -1 || dist[j] < dist[u])) u = j;

            vis[u] = true;

            for (int v = 0; v < V; v++) {
                if (g[u][v] != 0 && dist[u] + g[u][v] < dist[v]) {
                    dist[v] = dist[u] + g[u][v];
                    padre[v] = u;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print("0 -> " + i + " = " + dist[i] + " | Camino: ");
            imprimirCamino(padre, i);
            System.out.println();
        }
    }

    static void imprimirCamino(int[] padre, int j) {
        if (j == 0) {
            System.out.print("0 ");
            return;
        }
        imprimirCamino(padre, padre[j]);
        System.out.print(j + " ");
    }
}