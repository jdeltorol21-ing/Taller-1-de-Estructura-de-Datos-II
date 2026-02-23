/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafomatriz;

/**
 *
 * @author USER
 */


import java.util.*;

public class GrafoLista {

    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        grafo.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public void mostrarGrafo() {
        
        for (String vertice : grafo.keySet()) {
            System.out.println(vertice + " -> " + grafo.get(vertice));
        }
    }
    
   public void bfs(String inicio) {

    Set<String> visitados = new HashSet<>();
    Queue<String> cola = new LinkedList<>();

    visitados.add(inicio);
    cola.add(inicio);

    System.out.print("BFS: ");

    while (!cola.isEmpty()) {

        String actual = cola.poll();
        System.out.print(actual + " ");

        for (String vecino : grafo.get(actual)) {
            if (!visitados.contains(vecino)) {
                visitados.add(vecino);
                cola.add(vecino);
            }
        }
    }

    System.out.println();
}

    public static void main(String[] args) {

        GrafoLista grafo = new GrafoLista();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");

        grafo.mostrarGrafo();
        grafo.bfs("A");
    }
}
