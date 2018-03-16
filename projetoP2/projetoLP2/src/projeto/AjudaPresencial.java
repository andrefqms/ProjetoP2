package projeto;

import java.io.Serializable;

public class AjudaPresencial extends Ajuda implements Serializable {

	private String horario, dia, localInteresse;

	
	public AjudaPresencial(int id, String matricula, String disciplina, String horario, String dia, String localInteresse, String matriculaTutor)throws IllegalArgumentException {
		super(id,matricula, disciplina, matriculaTutor);
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

	public String getHorario() {
		return horario;
	}
		
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getLocalInteresse() {
		return localInteresse;
	}

	public void setLocalInteresse(String localInteresse) {
		this.localInteresse = localInteresse;
	}

	@Override
	public String toString() {
		return "horario - "+horario + ", dia - " + dia + ", local - " + localInteresse + ", disciplina - " + getDisciplina();
	}

	
	 
}
