package grafospkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class Prim {

	private int cantNodos;
	private int costoTotal;
	private Grafo grafo;
	private ArrayList<Integer> visitados;
	private ArrayList<Integer> restantes;

	public Prim(Grafo grafo) {
		this.cantNodos = grafo.getCantVertices();
		this.costoTotal = 0;
		this.grafo = grafo;
		grafo.espejarMatriz();
		this.visitados = new ArrayList<Integer>();
		this.restantes = new ArrayList<Integer>();

	}

	public void recorrido() {

//		int nodoOrigen = new Random().nextInt(this.cantNodos);
		int nodoOrigen = 0;
		inicializarRestantes(nodoOrigen, restantes);
		PriorityQueue<Arista> aristas = new PriorityQueue<Arista>(new AristaComparator());
		visitados.add(nodoOrigen);
		agregarAristas(nodoOrigen, aristas, grafo.getAdyacencia()[nodoOrigen]);

		while (!restantes.isEmpty()) {
			Arista menorArista = aristas.peek();
			costoTotal += menorArista.getPeso();
			System.out.println(menorArista.getOrigen() + "---" + menorArista.getDestino());
			System.out.println("Costo total:" + this.costoTotal);

			visitados.add(menorArista.getDestino());
			restantes.remove(restantes.indexOf(menorArista.getDestino()));

			agregarAristas(menorArista.getDestino(), aristas, grafo.getAdyacencia()[menorArista.getDestino()]);
			eliminarVisitadas(menorArista.getDestino(), aristas);
			aristas.remove(menorArista);
		}
		System.out.println();
	}

	private void eliminarVisitadas(int destino, PriorityQueue<Arista> aristas) {

		for (Iterator<Arista> iterator = aristas.iterator(); iterator.hasNext();) {
			Arista aux = iterator.next();
			if (aux.getDestino() == destino) {
				iterator.remove();
			}
		}

	}

	private void agregarAristas(int nodo, PriorityQueue<Arista> aristas, int[] aristasAdyacentes) {

		for (int s : restantes) {
			if (aristasAdyacentes[s] != Integer.MAX_VALUE && !existeArista(aristas, nodo, s, aristasAdyacentes[s])) {
				aristas.add(new Arista(nodo, s, aristasAdyacentes[s]));
			}
		}
	}

	private boolean existeArista(PriorityQueue<Arista> aristas, int origen, int destino, int peso) {

		Arista aux1 = new Arista(origen, destino, peso);
		Arista aux2 = new Arista(destino, origen, peso);
		if (aristas.contains(aux2) || aristas.contains(aux1)) {
			return true;
		}
		return false;
	}

	private void inicializarRestantes(int nodoOrigen, ArrayList<Integer> restantes) {

		for (int i = 0; i < this.cantNodos; i++) {
			if (nodoOrigen != i) {
				restantes.add(i);
			}
		}
	}

}
