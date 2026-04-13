
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Kruskal {
    static int V = 6;

    static class Arista implements Comparable<Arista> {
        int u, v, peso;
        public int compareTo(Arista o) {
            return this.peso - o.peso;
        }
    }

    static int[] padre = new int[V];

    static int find(int i) {
        if (padre[i] == i) return i;
        return padre[i] = find(padre[i]);
    }

    static void union(int a, int b) {
        padre[find(a)] = find(b);
    }

    public static void ejecutarKruskal() {
        List<Arista> lista = new ArrayList<>();

        int[][] datos = {
            {0,1,6},{0,2,1},{0,3,5},{1,2,2},{1,4,5},
            {2,3,2},{2,4,6},{3,5,4},{4,5,3}
        };

        for (int i = 0; i < V; i++) padre[i] = i;

        for (int[] d : datos) {
            Arista a = new Arista();
            a.u = d[0]; a.v = d[1]; a.peso = d[2];
            lista.add(a);
        }

        Collections.sort(lista);

        int costo = 0, descartadas = 0;

        for (Arista a : lista) {
            if (find(a.u) != find(a.v)) {
                union(a.u, a.v);
                System.out.println(a.u + " - " + a.v + " (" + a.peso + ")");
                costo += a.peso;
            } else {
                descartadas++;
            }
        }

        System.out.println("Descartadas: " + descartadas);
        System.out.println("Costo total: " + costo);
    }
}