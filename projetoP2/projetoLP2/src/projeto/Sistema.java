package projeto;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	ControllerAluno controllerAluno;
	ControllerTutor controllerTutor;
	private ArrayList<Tutor> tutoresAssociados;
	private ArrayList<Ajuda> pedidos;

	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerTutor = new ControllerTutor();
		this.tutoresAssociados = new ArrayList<>();
		this.pedidos = new ArrayList<>();

	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) throws IllegalArgumentException {
		AjudaPresencial ajuda = new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
		Tutor tutor = controllerTutor.ProcurarTutorProficiencia(controllerTutor.ProcurarTutorDisciplina(disciplina));
		if (controllerTutor.consultaHorario(tutor.getEmail(), horario, dia)
				&& controllerTutor.consultaLocal(tutor.getEmail(), localInteresse)) {
			tutoresAssociados.add(tutor);

		}
		pedidos.add(ajuda);
		return pedidos.size();
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) throws IllegalArgumentException {
		AjudaOnline ajuda = new AjudaOnline(matrAluno, disciplina);
		Tutor tutor = controllerTutor.ProcurarTutorProficiencia(controllerTutor.ProcurarTutorDisciplina(disciplina));
		tutoresAssociados.add(tutor);
		pedidos.add(ajuda);
		return pedidos.size();
	}

	public String pegarTutor(int idAjuda) throws IllegalArgumentException {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		if (idAjuda > tutoresAssociados.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return "Tutor - " + tutoresAssociados.get(idAjuda - 1).getMatricula() + ", "
				+ pedidos.get(idAjuda - 1).toString();
	}

	public String getInfoAjuda(int idAjuda, String atributo) throws IllegalArgumentException {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (atributo.trim().equals("") || atributo.equals(null)) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		if (idAjuda > tutoresAssociados.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		if (!atributo.equalsIgnoreCase("disciplina") && !atributo.equalsIgnoreCase("horario")
				&& !atributo.equalsIgnoreCase("dia") && !atributo.equalsIgnoreCase("localInteresse")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		String retorno = "";
		if (atributo.equals("disciplina")) {
			retorno = pedidos.get(idAjuda - 1).getDisciplina();
		} else if (atributo.equals("matricula")) {
			retorno = tutoresAssociados.get(idAjuda - 1).getMatricula();
		}

		return retorno;
	}

	public String avaliarTutor(int idAjuda, int nota) {
		tutoresAssociados.get(idAjuda - 1).setAvaliacao((tutoresAssociados.get(idAjuda - 1).getAvaliacao()*5 + nota)/6);
		return tutoresAssociados.get(idAjuda - 1).getMatricula();
	}
	
	public String pegarNota(String matriculaTutor) {
		String nota = "";
		for (Tutor tutor : controllerTutor.getTutores()) {
			if (tutor.getMatricula().equals(matriculaTutor)) {
				nota = String.format("%.2f", tutor.getAvaliacao());
			}
		}
		
		return nota;
	}
	
	public String pegarNivel(String matriculaTutor) {
		for (Tutor tutor : controllerTutor.getTutores()) {
			if (tutor.getMatricula().equals(matriculaTutor)) {
				
			}
		}
	}

	/**
	 * metodo que invoca o metodo cadastrarAluno do controllerAluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * metodo que invoca o metodo recuperaAluno do controllerAluno
	 */
	public String recuperaAluno(String matricula) {
		return controllerAluno.recuperaAluno(matricula);
	}

	/**
	 * metodo que invoca o metodo listarAlunos do controllerAluno
	 */
	public String listarAlunos() {
		return controllerAluno.listarAlunos();
	}

	/**
	 * metodo que invoca o metodo getInfoAluno do controllerAluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return controllerAluno.getInfoAluno(matricula, atributo);
	}

	/**
	 * metodo que invoca o metodo tornarTutor do controllerTutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws IllegalArgumentException {
		controllerTutor.tornarTutor(controllerAluno, matricula, disciplina, proficiencia);
	}

	/**
	 * metodo que invoca o metodo recuperaTutor do controllerTutor
	 */
	public String recuperaTutor(String matricula) throws IllegalArgumentException {
		return controllerTutor.recuperaTutor(matricula);
	}

	/**
	 * metodo que invoca o metodo listarTutores do controllerTutor
	 */
	public String listarTutores() {
		return controllerTutor.listarTutores();
	}

	/**
	 * metodo que invoca o metodo cadastrarHorario do controllerTutor
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		controllerTutor.cadastrarHorario(controllerTutor, email, horario, dia);
	}

	/**
	 * metodo que invoca o metodo cadastrarLocalDeAtendimento do controllerTutor
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		controllerTutor.cadastrarLocalDeAtendimento(controllerTutor, email, local);
	}

	/**
	 * metodo que invoca o metodo consultaHorario do controllerTutor
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return controllerTutor.consultaHorario(email, horario, dia);
	}

	/**
	 * metodo que invoca o metodo consultaLocal do controllerTutor
	 */
	public boolean consultaLocal(String email, String local) {
		return controllerTutor.consultaLocal(email, local);
	}

}
