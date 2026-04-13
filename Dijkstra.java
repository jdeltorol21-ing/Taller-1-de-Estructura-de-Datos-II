package com.mycompany.tallegrafos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS {
    static int V = 6;
    static List<Integer>[] grafo = new ArrayList[V];

    public static void ejecutarBFS(int inicio, int fin) {
        for (int i = 0; i < V; i++) grafo[i] = new ArrayList<>();

        grafo[0].add(1); grafo[0].add(2);
        grafo[1].add(3);
        grafo[2].add(3);
        grafo[3].add(4);
        grafo[4].add(5);

        Queue<Integer> cola;
        cola = new LinkedList<>();
        boolean[] visitado = new boolean[V];
        int[] padre = new int[V];
        Arrays.fill(padre, -1);

        cola.add(inicio);
        visitado[inicio] = true;

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            for (int vecino : grafo[nodo]) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    padre[vecino] = nodo;
                    cola.add(vecino);
                }
            }
        }

        List<Integer> camino = new ArrayList<>();
        for (int v = fin; v != -1; v = padre[v]) {
            camino.add(v);
        }
        Collections.reverse(camino);

        System.out.println("Camino: " + camino);
    }
}