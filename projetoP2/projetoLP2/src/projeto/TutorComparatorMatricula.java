package projeto;

import java.util.Comparator;

public class TutorComparatorMatricula implements Comparator<Tutor> {
	/**
	 * metodo compare da interface Comparator que compara dois tutores
	 */
	@Override
	public int compare(Tutor a1, Tutor a2) {
 		return a1.getMatricula().compareTo(a2.getMatricula());
	}
}
