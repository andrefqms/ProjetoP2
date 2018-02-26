package projeto;

public class Sistema {

	ControllerAluno controllerAluno;
	ControllerTutor controllerTutor;

	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerTutor = new ControllerTutor();
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	public String recuperaAluno(String matricula) {
		return controllerAluno.recuperaAluno(matricula);
	}

	public String listarAlunos() {
		return controllerAluno.listarAlunos();
	}

	public String getInfoAluno(String matricula, String atributo) {
		return controllerAluno.getInfoAluno(matricula, atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws IllegalArgumentException {
		controllerTutor.tornarTutor(controllerAluno,matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) throws IllegalArgumentException {
		return controllerTutor.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return controllerTutor.listarTutores();
	}
	public void cadastrarHorario(String email, String horario, String dia){
		controllerTutor.cadastrarHorario(controllerTutor, email, horario, dia);
	}
	public void cadastrarLocalDeAtendimento(String email, String local){
		controllerTutor.cadastrarLocalDeAtendimento(controllerTutor, email, local);
	}
	public boolean consultaHorario(String email, String horario, String dia){
		
	}
	public boolean consultaLocal(String email, String local){
		
	}

}
