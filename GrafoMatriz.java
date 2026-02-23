/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafomatriz;

/**
 *
 * @author USER
 */
import java.util.ArrayList;

public class GrafoMatriz {

    private ArrayList<String> vertices;
    private int[][] matriz;

    public GrafoMatriz(int tamaño) {
        vertices = new ArrayList<>();
        matriz = new int[tamaño][tamaño];
    }

    public void agregarVertice(String vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    public void agregarArista(String v1, String v2) {

        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);

        if (i != -1 && j != -1) {
            matriz[i][j] = 1;
            matriz[j][i] = 1; // no dirigido
        }
    }

    public void mostrarMatriz() {

        System.out.println("Matriz de Adyacencia:");

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GrafoMatriz grafo = new GrafoMatriz(4);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "A");

        grafo.mostrarMatriz();
    }
}