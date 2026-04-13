
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RedComputadores {
    static List<Integer>[] red = new ArrayList[6];

    public static void ejecutar() {
        for (int i = 0; i < 6; i++) red[i] = new ArrayList<>();

        agregarConexion(0,1);
        agregarConexion(1,4);
        agregarConexion(4,5);

        System.out.println("Conexion 0 -> 5: " + puedeLlegar(0,5));
        caminoMasCorto(0,5);
    }

    static void agregarConexion(int a, int b) {
        red[a].add(b);
        red[b].add(a);
    }

    static boolean puedeLlegar(int inicio, int fin) {
        boolean[] vis = new boolean[6];
        Queue<Integer> q = new LinkedList<>();
        q.add(inicio);
        vis[inicio] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == fin) return true;
            for (int v : red[n]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return false;
    }

    static void caminoMasCorto(int inicio, int fin) {
        boolean[] vis = new boolean[6];
        int[] padre = new int[6];
        Arrays.fill(padre, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(inicio);
        vis[inicio] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int v : red[n]) {
                if (!vis[v]) {
                    vis[v] = true;
                    padre[v] = n;
                    q.add(v);
                }
            }
        }

        List<Integer> camino = new ArrayList<>();
        for (int v = fin; v != -1; v = padre[v]) camino.add(v);
        Collections.reverse(camino);

        System.out.println("Camino: " + camino);
    }
}
