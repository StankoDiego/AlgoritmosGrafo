package grafospkg;

public class MainGrafos {

	private static final String PATH_DIJKSTRA = "archivoDijkstra";

	public static void main(String[] args) {
		Grafo grafo = new Grafo(PATH_DIJKSTRA);
		grafo.mostrarMatriz();
		
		Dijstrak dij = new Dijstrak(0, grafo);
		
		dij.recorridoDijstrak();
		System.out.println();
	}
}
