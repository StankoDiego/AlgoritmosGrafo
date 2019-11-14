package grafospkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo {

	private int cantVertices;
	private int cantAristas;

	private int adyacencia[][];

	public Grafo(String path) {
		FileManager.leerArchivo(path, this);
	}

	public void recorridoAnchura(int nodoOrigen) {
		ArrayList<Integer> visitado = new ArrayList<Integer>();
		Queue<Integer> cola = new LinkedList<Integer>();

		int distancia[] = new int[this.cantVertices];
		int padre[] = new int[this.cantVertices];

		inicializarVectores(distancia);
		distancia[nodoOrigen] = 0;
		cola.add(nodoOrigen);
		visitado.add(nodoOrigen);

		while (!cola.isEmpty()) {
			int nodoActual = cola.poll();

			for (int i = 1; i < this.adyacencia.length; i++) {
				if (!visitado.contains(i) && this.adyacencia[nodoActual][i] != Integer.MAX_VALUE) {
					visitado.add(i);
					distancia[i] = distancia[nodoActual] + 1;
					padre[i] = nodoActual;
					cola.add(i);
				}
			}
		}
	}

	public void recorridoProfundidad(int nodoOrigen) {

		Stack<Integer> pila = new Stack<Integer>();
		ArrayList<Integer> visitados = new ArrayList<Integer>();
		visitados.add(nodoOrigen);
		pila.push(nodoOrigen);

		while (!pila.isEmpty()) {
			int nodoActual = pila.pop();
			System.out.println(nodoActual + " ");

			for (int i = 0; i < adyacencia.length; i++) {
				if (!visitados.contains(i) && this.adyacencia[nodoActual][i] != Integer.MAX_VALUE) {
					visitados.add(i);
					pila.push(i);
				}
			}
		}
	}

	private void inicializarVectores(int[] distancia) {
		for (int i = 0; i < distancia.length; i++) {
			distancia[i] = Integer.MAX_VALUE;
		}
	}

	// GET Y SETTER
	public int getCantVertices() {
		return cantVertices;
	}

	public void setCantVertices(int cantVertices) {
		this.cantVertices = cantVertices;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int[][] getAdyacencia() {
		return adyacencia;
	}

	public void setAdyacencia(int[][] adyacencia) {
		this.adyacencia = adyacencia;
	}
}
