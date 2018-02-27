package projeto;

import java.util.ArrayList;

public class Tutor extends Aluno{

	private ArrayList<String> horarios;
	private ArrayList<String> dias;
	private String local;
	private int proficiencia,avaliacao,dinheiro;
	private ArrayList<String> disciplinas;
		
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		
		this.disciplinas = new ArrayList<String>();
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.dinheiro = 0;
		this.dias = new ArrayList<String>();
		this.horarios = new ArrayList<String>();
		this.local = "";
	}

	public ArrayList<String> getDisciplinas() {
		return disciplinas;
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
	
	public ArrayList<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<String> horarios) {
		this.horarios = horarios;
	}

	public ArrayList<String> getDias() {
		return dias;
	}

	public void setDias(ArrayList<String> dias) {
		this.dias = dias;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
