package projeto;

import java.util.Comparator;

public class AlunoComparator implements Comparator<Aluno> {
	/**
	 * metodo compare da interface Comparator que compara dois alunos
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
	if( a1.getNome().compareTo(a2.getNome()) == 0){
 		return a1.getMatricula().compareTo(a2.getMatricula());
	}
	return a1.getNome().compareTo(a2.getNome());
	}
}
