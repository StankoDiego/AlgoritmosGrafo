package grafospkg;

import java.util.ArrayList;

public class Dijstrak {

	private int[] predecesores;
	private int[] distancia;
	private ArrayList<Integer> visitados;
	private ArrayList<Integer> restantes;
	private Grafo grafo;
	private int nodoOrigen;

	public Dijstrak(int nodoOrigen, Grafo grafo) {
		this.nodoOrigen = nodoOrigen;
		this.grafo = grafo;
		this.predecesores = new int[grafo.getCantVertices()];

		this.visitados = new ArrayList<Integer>();
		this.distancia = new int[grafo.getCantVertices()];
		this.restantes = new ArrayList<Integer>();

		visitados.add(nodoOrigen);
		inicializarElementos(nodoOrigen, restantes, predecesores, distancia);
	}

	private void inicializarElementos(int nodoOrigen, ArrayList<Integer> restantes, int[] predecesores,
			int[] distancia) {

		for (int i = 0; i < grafo.getCantVertices(); i++) {
			distancia[i] = grafo.getAdyacencia()[nodoOrigen][i];
			predecesores[i] = nodoOrigen;
			if (i != nodoOrigen)
				restantes.add(i);
		}
	}

	public void recorridoDijstrak() {

		for (int i = 0; i < grafo.getCantVertices(); i++) {
			// BUSCO EL MINIMO EN RESTANTES
			int nodoMinimo = buscarMinimo(restantes, distancia);
			if (nodoMinimo != -1) {
				// SI SE ENCONTRO
				visitados.add(nodoMinimo);
				restantes.remove(restantes.indexOf(nodoMinimo));
				// POR CADA RESTANTE
				for (Integer x : restantes) {
					if (this.grafo.getAdyacencia()[nodoMinimo][x] != Integer.MAX_VALUE) {
						// Calculo el costo de un intermedio
						int costoIntermedio = this.grafo.getAdyacencia()[nodoMinimo][x] + distancia[nodoMinimo];
						if (costoIntermedio < distancia[x]) {
							distancia[x] = costoIntermedio;
							predecesores[x] = nodoMinimo;
						}
					}
				}
			}
		}

		armarCamino();
	}

	private int buscarMinimo(ArrayList<Integer> restantes, int[] distancia) {
		int pos = -1;
		int minimo = Integer.MAX_VALUE;

		for (int restante : restantes) {
			if (distancia[restante] != Integer.MAX_VALUE && distancia[restante] < minimo) {
				minimo = distancia[restante];
				pos = restante;
			}
		}
		return pos;
	}

	private void armarCamino() {

		System.out.print(predecesores.length + " ");
		int i = this.predecesores.length - 1;
		while (i != this.nodoOrigen) {
			System.out.print(this.predecesores[i] + 1 + " ");
			i = this.predecesores[i];
		}
	}

}