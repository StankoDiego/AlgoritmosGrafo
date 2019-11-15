package grafospkg;

import java.util.Comparator;

public class AristaComparator implements Comparator<Arista> {

	@Override
	public int compare(Arista arg0, Arista arg1) {
		return arg0.getPeso() > arg1.getPeso() ? 1 : -1;
	}

}
