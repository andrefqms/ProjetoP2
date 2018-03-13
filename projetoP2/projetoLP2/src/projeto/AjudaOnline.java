package projeto;

public class AjudaOnline extends Ajuda{

	public AjudaOnline(int id,String matricula, String disciplina, String matriculaTutor)throws IllegalArgumentException {
		super(id, matricula, disciplina, matriculaTutor);
		if(matricula.trim().equals("") || matricula.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if(disciplina.trim().equals("") || disciplina.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		
	}

	@Override
	public String toString() {
		return ", disciplina - " + getDisciplina();
	}
}
