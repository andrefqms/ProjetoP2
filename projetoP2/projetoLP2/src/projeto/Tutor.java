package projeto;

import java.util.ArrayList;

public class Tutor extends Aluno {
	/**
	 * Atributos
	 */
	private ArrayList<String> horarios;
	private ArrayList<String> dias;
	private String local;
	private int proficiencia, avaliacao, dinheiro;
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
	/**
	 * metodo que retorna as disciplinas
	 */
	public ArrayList<String> getDisciplinas() {
		return disciplinas;
	}
	/**
	 * metodo acessor da proficiencia
	 */
	public int getProficiencia() {
		return proficiencia;
	}
	/**
	 * metodo que retorna a avaliacao
	 */
	public int getAvaliacao() {
		return avaliacao;
	}
	/**
	 * metodo que retorna o dinheiro
	 */
	public int getDinheiro() {
		return dinheiro;
	}
	/**
	 * metodo que retorna os horarios
	 */
	public ArrayList<String> getHorarios() {
		return horarios;
	}
	/**
	 * metodo que troca os horarios
	 */
	public void setHorarios(ArrayList<String> horarios) {
		this.horarios = horarios;
	}
	/**
	 * metodo que retorna os dias
	 */
	public ArrayList<String> getDias() {
		return dias;
	}
	/**
	 * metodo que modifica os dias
	 */
	public void setDias(ArrayList<String> dias) {
		this.dias = dias;
	}
	/**
	 * metodo acessor da string local
	 */
	public String getLocal() {
		return local;
	}
	/**
	 * metodo modificador do local
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * representacao textual da classe
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
