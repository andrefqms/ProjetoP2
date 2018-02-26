package projeto;

public class Tutor extends Aluno{

	private String disciplina,dia,horario,local;
	private int proficiencia,avaliacao,dinheiro;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina,int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.dinheiro = 0;
		this.dia = "";
		this.horario = "";
		this.local = "";
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
	
	public String getDia() {
		return dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
