package grafospkg;

public class MainGrafos {

	private static final String PATH_DIJKSTRA = "archivoDijkstra";
	private static final String PATH_PRIM = "archivoKruskalPrim.txt";

	public static void main(String[] args) {

		// DIJKSTRA
		Grafo grafo = new Grafo(PATH_DIJKSTRA);
		// grafo.mostrarMatriz();
		Dijstrak dij = new Dijstrak(0, grafo);
//		dij.recorridoDijstrak();
		System.out.println();

		// PRIM
		Grafo grafo1 = new Grafo(PATH_PRIM);
		Prim prim = new Prim(grafo1);
//		grafo1.mostrarMatriz();
		prim.recorrido();
	}
}
