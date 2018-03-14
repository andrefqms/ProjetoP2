package projeto;

import java.util.Comparator;

public class TutorComparatorEmail  implements Comparator<Tutor> {
	/**
	 * metodo compare da interface Comparator que compara dois  tutores
	 */
	@Override
	public int compare(Tutor a1, Tutor a2) {
	if( a1.getNome().compareTo(a2.getNome()) == 0){
 		return a1.getMatricula().compareTo(a2.getMatricula());
	}
	return a1.getEmail().compareTo(a2.getEmail());
	}
}