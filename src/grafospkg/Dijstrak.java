package grafospkg;

import java.util.ArrayList;

public class Dijstrak {

	private int[] predecesores;
	private int[] distancia;
	ArrayList<Integer> visitados;
	ArrayList<Integer> restantes;
	Grafo grafo;
	int nodoOrigen;

	public Dijstrak(int nodoOrigen, Grafo grafo) {
		this.nodoOrigen = nodoOrigen;
		this.grafo = grafo;
		this.predecesores = new int[grafo.getCantVertices()];

		this.visitados = new ArrayList<Integer>();
		this.distancia = new int[grafo.getCantAristas()];
		this.restantes = new ArrayList<Integer>();

		visitados.add(nodoOrigen);
		inicializarElementos(nodoOrigen, restantes, predecesores, distancia);
	}

	public void inicializarElementos(int nodoOrigen, ArrayList<Integer> restantes, int[] predecesores,
			int[] distancia) {

		for (int i = 0; i < grafo.getCantVertices(); i++) {
			distancia[i] = grafo.getAdyacencia()[nodoOrigen][i];
			predecesores[i] = nodoOrigen;
			if (i != nodoOrigen)
				restantes.add(i);
		}
	}

	public void RecorridoDijstrak() {

		for (int i = 0; i < grafo.getCantVertices(); i++) {

			int pos = buscarMinimo(restantes, distancia);
			int nodoMinimo = restantes.get(pos);
			visitados.add(nodoMinimo);
			restantes.remove(pos);

			if (pos != -1) {

			}

		}

	}

	private int buscarMinimo(ArrayList<Integer> restantes2, int[] distancia) {
		return 0;
	}

}