package projeto;

public class Sistema {

	ControllerAluno controllerAluno;

	public Sistema() {
		controllerAluno = new ControllerAluno();
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

	public void tornarTutor(String matricula, String disciplina, int proficiencia)throws IllegalArgumentException {
		controllerAluno.tornarTutor(matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula)throws IllegalArgumentException {
		return controllerAluno.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return controllerAluno.listarTutores();
	}

}
