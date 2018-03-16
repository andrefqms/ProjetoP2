package projeto;

import java.util.Comparator;

public class AlunoComparatorMatricula implements Comparator<Aluno> {
	/**
	 * metodo compare da interface Comparator que compara dois alunos
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());
	}
}
