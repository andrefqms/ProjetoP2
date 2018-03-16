package projeto;

import java.io.Serializable;

public class AjudaOnline extends Ajuda implements Serializable{

	public AjudaOnline(int id,String matricula, String disciplina, String matriculaTutor)throws IllegalArgumentException {
		super(id, matricula, disciplina, matriculaTutor);
		if(matricula.trim().equals("") || matricula.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if(disciplina.trim().equals("") || disciplina.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		
	}
	/**
	 * metodo que retorna a representacao textual da classe
	 * @return
	 */
	@Override
	public String toString() {
		return ", disciplina - " + getDisciplina();
	}
}
