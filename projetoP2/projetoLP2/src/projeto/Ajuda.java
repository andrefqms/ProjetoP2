package projeto;

import java.io.Serializable;

public abstract class Ajuda implements Serializable{

	private String disciplina;
	private String matricula;
	private boolean avaliado;
	private String matriculaTutor;
	private int id;

	public Ajuda(int id, String matricula, String disciplina, String matriculaTutor) {
		super();
		this.avaliado = false;
		this.disciplina = disciplina;
		this.matricula = matricula;
		this.matriculaTutor = matriculaTutor;
		this.id = 0;
		
	}
	/**
	 * metodo acessor da id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * metodo modificador da id
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}

	public boolean getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(boolean avaliado) {
		this.avaliado = avaliado;
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

	public String getMatriculaTutor() {
		return matriculaTutor;
	}

	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
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
