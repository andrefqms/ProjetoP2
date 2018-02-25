package projeto;

public class Tutor extends Aluno{

	private String disciplina;
	private int proficiencia,avaliacao,dinheiro;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina,int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.dinheiro = 0;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public int getDinheiro() {
		return dinheiro;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
