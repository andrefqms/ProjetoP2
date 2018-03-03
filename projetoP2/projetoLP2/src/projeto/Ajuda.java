package projeto;

public abstract class Ajuda {

	private String disciplina;
	private String matricula;
	
	public Ajuda(String matricula, String disciplina) {
		super();
		this.disciplina = disciplina;
		this.matricula = matricula;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return disciplina + " - " + matricula;
	}
	
	
}
