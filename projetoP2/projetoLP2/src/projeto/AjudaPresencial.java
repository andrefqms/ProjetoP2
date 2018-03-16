package projeto;

public class AjudaPresencial extends Ajuda {

	private String horario, dia, localInteresse;
	/**
	 * Classe que herda da classe Ajuda
	 * @param matricula
	 * @param disciplina
	 * @param horario
	 * @param dia
	 * @param localInteresse
	 * @throws IllegalArgumentException
	 */
	public AjudaPresencial(String matricula, String disciplina, String horario, String dia, String localInteresse)throws IllegalArgumentException {
		super(matricula, disciplina);
		if(matricula.trim().equals("") || matricula.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if(disciplina.trim().equals("") || disciplina.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if(horario.trim().equals("") || horario.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		if(dia.trim().equals("") || dia.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		if(localInteresse.trim().equals("") || localInteresse.equals(null)){
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;		
	}
	/**
	 * metodo acessor da horario
	 * @return
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * metodo modificador do horario
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * metodo acessor da dia
	 * @return
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * metodo modificador da dia
	 * 
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * metodo acessor do Local
	 * @return
	 */
	public String getLocalInteresse() {
		return localInteresse;
	}
	/**
	 * metodo modificador do Local
	 * @return
	 */
	public void setLocalInteresse(String localInteresse) {
		this.localInteresse = localInteresse;
	}
	/**
	 * metodo que retorna a representacao textual da classe
	 * @return
	 */
	@Override
	public String toString() {
		return "horario - "+horario + ", dia - " + dia + ", local - " + localInteresse + ", disciplina - " + getDisciplina();
	}

	
	 
}
