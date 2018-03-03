package projeto;

public class AjudaOnline extends Ajuda{

	public AjudaOnline(String matricula, String disciplina)throws IllegalArgumentException {
		super(matricula, disciplina);
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
