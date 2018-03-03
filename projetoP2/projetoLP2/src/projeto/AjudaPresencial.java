package projeto;

public class AjudaPresencial extends Ajuda {

	private String horario, dia, localInteresse;
	
	public AjudaPresencial(String matricula, String disciplina, String horario, String dia, String localInteresse) {
		super(matricula, disciplina);
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

	
	 
}
