package projeto;

import java.util.ArrayList;

public class Tutor extends Aluno implements Comparable<Tutor>{
	/**
	 * Atributos
	 */
	private ArrayList<String> horarios;
	private ArrayList<String> dias;
	private String local;
	private int proficiencia;
	private double dinheiro;
	private ArrayList<String> disciplinas;
	private double avaliacao;
	public String Nivel;

	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, int proficiencia)throws IllegalArgumentException {
		super(nome, matricula, codigoCurso, telefone, email);
		this.disciplinas = new ArrayList<String>();
		this.proficiencia = proficiencia;
		this.avaliacao = 4.00;
		this.dinheiro = 0.0;
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
	public double getAvaliacao() {
		return avaliacao;
	}
	/**
	 * metodo que retorna o dinheiro
	 */
	public double getDinheiro() {
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
	 * metodo modificador do dinheiro
	 */
	public void setDinheiro(double d) {
		this.dinheiro += d;
	}/**
	 * metodo modificador da avaliacao
	 */
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	/**
	 * representacao textual da classe
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	/**
	 * metodo de ordenacao compareTo
	 */
	@Override
	public int compareTo(Tutor o) {
		if(this.proficiencia > o.getProficiencia()){
			return 1;
		}
		else if(this.proficiencia < o.getProficiencia()){
			return -1;
		}
		else{
			return 0;
		}
	}
	public String getNivel() {
		if(this.avaliacao > 4.5){
			return "TOP";
		}else if(this.avaliacao > 3 && this.avaliacao <= 4.5){
			return "Tutor";
		}else{
			return "Aprendiz";
		}
	}

}
