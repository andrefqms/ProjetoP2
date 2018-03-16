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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(boolean avaliado) {
		this.avaliado = avaliado;
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

	public String getMatriculaTutor() {
		return matriculaTutor;
	}

	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
	}

	@Override
	public String toString() {
		return disciplina + " - " + matricula;
	}

}
