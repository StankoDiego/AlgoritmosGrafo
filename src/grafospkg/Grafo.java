package grafospkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Grafo {

	private int cantVertices;
	private int cantAristas;

	private int adyacencia[][];

	public Grafo(String path) {
		FileManager.leerArchivo(path, this);
	}

	public int[] bfs(int nodoOrigen) {
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


		return distancia;
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
