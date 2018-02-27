package projeto;

public class Sistema {

	ControllerAluno controllerAluno;
	ControllerTutor controllerTutor;

	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerTutor = new ControllerTutor();
	}
	/**
	 * metodo que invoca o metodo  cadastrarAluno do controllerAluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	/**
	 * metodo que invoca o metodo  recuperaAluno do controllerAluno
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
