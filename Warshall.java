
package com.mycompany.tallegrafos;

import java.util.*;

public class Tallegrafos {

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        }
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static void prim(int start, int V, List<List<Edge>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[start] = true;
        pq.addAll(adj.get(start));
        int cost = 0;

        System.out.println("Prim desde nodo " + start);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.v]) continue;
            visited[e.v] = true;
            cost += e.w;
            System.out.println(e.u + " - " + e.v + " (" + e.w + ")");
            for (Edge next : adj.get(e.v)) {
                if (!visited[next.v]) pq.add(next);
            }
        }
        System.out.println("Costo total MST: " + cost);
    }

    static int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }

    static void union(int[] parent, int x, int y) {
        parent[find(parent, y)] = find(parent, x);
    }

    static void kruskal(int V, List<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int cost = 0, discarded = 0;
        System.out.println("Kruskal:");

        for (Edge e : edges) {
            int rootU = find(parent, e.u);
            int rootV = find(parent, e.v);

            if (rootU != rootV) {
                union(parent, rootU, rootV);
                cost += e.w;
                System.out.println(e.u + " - " + e.v + " (" + e.w + ")");
            } else discarded++;
        }

        System.out.println("Costo total MST: " + cost);
        System.out.println("Descartadas: " + discarded);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        List<Edge> edges = new ArrayList<>();

        int[][] data = {
            {0,1,6},{0,2,1},{0,3,5},{1,2,2},{1,4,5},
            {2,3,2},{2,4,6},{3,5,4},{4,5,3}
        };

        for (int[] e : data) {
            adj.get(e[0]).add(new Edge(e[0], e[1], e[2]));
            adj.get(e[1]).add(new Edge(e[1], e[0], e[2]));
            edges.add(new Edge(e[0], e[1], e[2]));
        }

        prim(0, V, adj);
        prim(2, V, adj);
        kruskal(V, edges);
    }
}


