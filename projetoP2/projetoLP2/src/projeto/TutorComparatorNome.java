package projeto;

import java.util.Comparator;

public class TutorComparatorNome implements Comparator<Tutor> {
	/**
	 * metodo compare da interface Comparator que compara nomes de dois tutores e desempata com a matricula
	 */
	@Override
	public int compare(Tutor a1, Tutor a2) {
	if( a1.getNome().compareTo(a2.getNome()) == 0){
 		return a1.getMatricula().compareTo(a2.getMatricula());
	}
	return a1.getNome().compareTo(a2.getNome());
	}
}