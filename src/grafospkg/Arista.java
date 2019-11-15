package grafospkg;

public class Arista {

	private int nodoOrigen;
	private int nodoDestino;
	private int peso;

	public Arista(int nodoOrigen, int nodoDestino, int peso) {
		this.nodoDestino = nodoDestino;
		this.nodoOrigen = nodoOrigen;
		this.peso = peso;
	}

	public int getPeso() {
		return this.peso;
	}

	public int getDestino() {
		return this.nodoDestino;
	}

	public int getOrigen() {
		return this.nodoOrigen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodoDestino;
		result = prime * result + nodoOrigen;
		result = prime * result + peso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (nodoDestino != other.nodoDestino)
			return false;
		if (nodoOrigen != other.nodoOrigen)
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}
	
	

}
