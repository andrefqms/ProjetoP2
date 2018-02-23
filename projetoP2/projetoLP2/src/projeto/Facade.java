package projeto;

import easyaccept.EasyAccept;

public class Facade {

	private Sistema sistema;

	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt"};
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
}
