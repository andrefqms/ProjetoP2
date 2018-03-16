package projeto;

import java.io.Serializable;
import java.util.Comparator;

public class AlunoComparator implements Comparator<Aluno>, Serializable {
	/**
	 * metodo compare da interface Comparator que compara dois alunos
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}
}
