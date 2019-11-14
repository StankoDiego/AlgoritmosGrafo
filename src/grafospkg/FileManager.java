package grafospkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

	public static void leerArchivo(String path, Grafo grafo) {

		File fArchivo = new File(path);
		Scanner sc = null;

		try {
			sc = new Scanner(fArchivo);
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo");
			System.exit(1);
		}

		grafo.setCantVertices(sc.nextInt());
		grafo.setCantAristas(sc.nextInt());

		int[][] m = new int[grafo.getCantVertices()][grafo.getCantVertices()];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < grafo.getCantAristas(); i++) {
			int fila = sc.nextInt();
			int columna = sc.nextInt();
			int valor = sc.nextInt();
			m[fila - 1][columna - 1] = valor;
		}

		grafo.setAdyacencia(m);
		sc.close();
	}
}
