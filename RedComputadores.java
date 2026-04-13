import java.util.*;
class Prim {
    static int V = 6;
    static int[][] grafo = {
        {0,6,1,5,0,0},
        {6,0,2,0,5,0},
        {1,2,0,2,6,0},
        {5,0,2,0,0,4},
        {0,5,6,0,0,3},
        {0,0,0,4,3,0}
    };

    public static void ejecutarPrim(int inicio) {
        boolean[] visitado = new boolean[V];
        visitado[inicio] = true;
        int aristas = 0, costo = 0;

        while (aristas < V - 1) {
            int min = Integer.MAX_VALUE;
            int x = -1, y = -1;

            for (int i = 0; i < V; i++) {
                if (visitado[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!visitado[j] && grafo[i][j] != 0 && grafo[i][j] < min) {
                            min = grafo[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " (" + grafo[x][y] + ")");
            costo += grafo[x][y];
            visitado[y] = true;
            aristas++;
        }
        System.out.println("Costo total: " + costo);
    }
}