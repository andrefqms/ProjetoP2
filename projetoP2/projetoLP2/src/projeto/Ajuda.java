package projeto;

public abstract class Ajuda {

	private String disciplina;
	private String matricula;
	
	public Ajuda(String matricula, String disciplina) {
		super();
		this.disciplina = disciplina;
		this.matricula = matricula;
	}
	/**
	 * metodo acessor da disciplina
	 * @return
	 */
	public String getDisciplina() {
		return disciplina;
	}
	/**
	 * metodo modificador da disciplina
	 * 
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	/**
	 * metodo acessor da matricula
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * metodo modificador da matricula
	 * @return
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * metodo que retorna a representacao textual da classe
	 * @return
	 */
	@Override
	public String toString() {
		return disciplina + " - " + matricula;
	}
	
	
}
