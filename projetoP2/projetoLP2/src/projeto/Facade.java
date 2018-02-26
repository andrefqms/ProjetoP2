package projeto;

import easyaccept.EasyAccept;

public class Facade {

	private Sistema sistema;

	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt","acceptance_test/us3_test.txt"};
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.sistema = new Sistema();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.sistema.controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return this.sistema.controllerAluno.recuperaAluno(matricula);
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.sistema.controllerAluno.getInfoAluno(matricula, atributo);
	}
	
	public String listarAlunos() {
		return this.sistema.controllerAluno.listarAlunos();
	}
	public void tornarTutor(String matricula, String disciplina, int proficiencia){
		this.sistema.controllerTutor.tornarTutor(sistema.controllerAluno, matricula, disciplina, proficiencia);
	}
	public String recuperaTutor(String matricula){
		return this.sistema.controllerTutor.recuperaTutor(matricula);
	}
	public String listarTutores(){
		return this.sistema.controllerTutor.listarTutores();
	}
	public void cadastrarHorario(String email, String horario, String dia){
		this.sistema.controllerTutor.cadastrarHorario(sistema.controllerTutor, email, horario, dia);
	}
	public void cadastrarLocalDeAtendimento(String email, String local){
		this.sistema.controllerTutor.cadastrarLocalDeAtendimento(sistema.controllerTutor, email, local);
	}
	public boolean consultaHorario(String email, String horario, String dia){
		
	}
	public boolean consultaLocal(String email, String local){
		
	}

}
