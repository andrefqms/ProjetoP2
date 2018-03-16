package projeto;

import java.util.Comparator;

public class AlunoComparatorEmail implements Comparator<Aluno> {
	/**
	 * metodo compare da interface Comparator que compara emails de dois alunos e desempata com a matricula
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		if( a1.getEmail().compareTo(a2.getEmail()) == 0){
	 		return a1.getMatricula().compareTo(a2.getMatricula());

		}
		return a1.getEmail().compareTo(a2.getEmail());
	}
}
