package projeto;

import easyaccept.EasyAccept;

public class Facade {

	private Sistema sistema;
	private ControllerTutor controllerTutor;

	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt","acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt"};
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.sistema = new Sistema();
		this.controllerTutor = new ControllerTutor();
	}
	/**
	 * Delegacao do metodo cadastrarAluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.sistema.controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	/**
	 * Delegacao do metodo recuperaAluno
	 */
	public String recuperaAluno(String matricula) {
		return this.sistema.controllerAluno.recuperaAluno(matricula);
	}
	/**
	 * Delegacao do metodo getInfoAluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.sistema.controllerAluno.getInfoAluno(matricula, atributo);
	}
	/**
	 * Delegacao do metodo listarAlunos
	 */
	public String listarAlunos() {
		return this.sistema.controllerAluno.listarAlunos();
	}/**
	 * Delegacao do metodo tornarTutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia){
		this.sistema.controllerTutor.tornarTutor(sistema.controllerAluno, matricula, disciplina, proficiencia);
	}/**
	 * Delegacao do metodo recuperaTutor
	 */
	public String recuperaTutor(String matricula){
		return this.sistema.controllerTutor.recuperaTutor(matricula);
	}/**
	 * Delegacao do metodo listarTutores
	 */
	public String listarTutores(){
		return this.sistema.controllerTutor.listarTutores();
	}/**
	 * Delegacao do metodo cadastrarHorario
	 */
	public void cadastrarHorario(String email, String horario, String dia){
		this.sistema.controllerTutor.cadastrarHorario(sistema.controllerTutor, email, horario, dia);
	}/**
	 * Delegacao do metodo cadastrarLocalDeAtendimento
	 */
	public void cadastrarLocalDeAtendimento(String email, String local){
		this.sistema.controllerTutor.cadastrarLocalDeAtendimento(sistema.controllerTutor, email, local);
	}/**
	 * Delegacao do metodo consultaHorario
	 */
	public boolean consultaHorario(String email, String horario, String dia){
		return this.sistema.controllerTutor.consultaHorario(email, horario, dia);
	}/**
	 * Delegacao do metodo consultaLocal
	 */
	public boolean consultaLocal(String email, String local){
		return this.sistema.controllerTutor.consultaLocal(email, local);
	}
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse){
		return this.controllerTutor.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	public int pedirAjudaOnline (String disciplina){
		return this.sistema.pedirAjudaOnline(disciplina);
	}
	public String pegarTutor(int idAjuda){
		return this.sistema.pegarTutor(idAjuda);
	}
	public String getInfoAjuda(int idAjuda, String atributo){
		return this.sistema.getInfoAjuda(idAjuda, atributo);
	}
}
