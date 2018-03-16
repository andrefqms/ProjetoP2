package projeto;

import java.io.IOException;

import easyaccept.EasyAccept;

public class Facade {
	
	Arquivo arquivo;
	private ControllerTutor controllerTutor;
	private ControllerAluno controllerAluno;

	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		this.arquivo = new Arquivo();
		this.controllerTutor = new ControllerTutor();
		this.controllerAluno = new ControllerAluno();
	}

	/**
	 * Delegacao do metodo cadastrarAluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Delegacao do metodo recuperaAluno
	 */
	public String recuperaAluno(String matricula) {
		return this.controllerAluno.recuperaAluno(matricula);
	}

	/**
	 * Delegacao do metodo getInfoAluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.controllerAluno.getInfoAluno(matricula, atributo);
	}

	/**
	 * Delegacao do metodo listarAlunos
	 */
	public String listarAlunos() {
		return this.controllerAluno.listarAlunos();
	}

	/**
	 * Delegacao do metodo tornarTutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.controllerTutor.tornarTutor(controllerAluno, matricula, disciplina, proficiencia);
	}

	/**
	 * Delegacao do metodo recuperaTutor
	 */
	public String recuperaTutor(String matricula) {
		return this.controllerTutor.recuperaTutor(matricula);
	}

	/**
	 * Delegacao do metodo listarTutores
	 */
	public String listarTutores() {
		return this.controllerTutor.listarTutores();
	}

	/**
	 * Delegacao do metodo cadastrarHorario
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.controllerTutor.cadastrarHorario(controllerTutor, email, horario, dia);
	}

	/**
	 * Delegacao do metodo cadastrarLocalDeAtendimento
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.controllerTutor.cadastrarLocalDeAtendimento(controllerTutor, email, local);
	}

	/**
	 * Delegacao do metodo consultaHorario
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.controllerTutor.consultaHorario(email, horario, dia);
	}

	/**
	 * Delegacao do metodo consultaLocal
	 */
	public boolean consultaLocal(String email, String local) {
		return this.controllerTutor.consultaLocal(email, local);
	}
	/**
	 * Delegacao do metodo pedirAjudaPresencial
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return this.controllerTutor.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	/**
	 * Delegacao do metodo pedirAjudaOnline
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.controllerTutor.pedirAjudaOnline(matrAluno, disciplina);
	}
	/**
	 * Delegacao do metodo pegarTutor
	 */
	public String pegarTutor(int idAjuda) {
		return this.controllerTutor.pegarTutor(idAjuda);
	}
	/**
	 * Delegacao do metodo getInfoAjuda
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.controllerTutor.getInfoAjuda(idAjuda, atributo);
	}
	/**
	 * Delegacao do metodo avaliarTutor
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		return this.controllerTutor.avaliarTutor(idAjuda, nota);
	}
	/**
	 * Delegacao do metodo pegarNota
	 */
	public String pegarNota(String matriculaTutor) {
		return this.controllerTutor.pegarNota(matriculaTutor);
	}
	/**
	 * Delegacao do metodo pegarNivel
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.controllerTutor.pegarNivel(matriculaTutor);
	}
	/**
	 * Delegacao do metodo doar
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		this.controllerTutor.doar(matriculaTutor, totalCentavos);
		;
	}
	/**
	 * Delegacao do metodo totalDinheiroTutor
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return this.controllerTutor.totalDinheiroTutor(emailTutor);
	}
	/**
	 * Delegacao do metodo totalDinheiroSistema
	 */
	public int totalDinheiroSistema() {
		return this.controllerTutor.totalDinheiroSistema();

	}
	/**
	 * Delegacao do metodo configurarOrdem
	 */
	public void configurarOrdem(String atributo) {
		this.controllerAluno.configurarOrdem(atributo);
		this.controllerTutor.configurarOrdem(atributo);
	}
	/**
	 * Delegacao do metodo Salvar
	 */
	public void Salvar(){
		this.arquivo.addRecords();
	}
	/**
	 * Delegacao do metodo Carregar
	 */
	public void Carregar(){
		this.arquivo.Read();
	}
}
