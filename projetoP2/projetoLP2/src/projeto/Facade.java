package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import easyaccept.EasyAccept;

public class Facade implements Serializable {

	private ControllerTutor controllerTutor;
	private ControllerAluno controllerAluno;

	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt"};
		EasyAccept.main(args);
	}
	
	public Facade() {
		this.controllerTutor = new ControllerTutor();
		this.controllerAluno = new ControllerAluno();
	}
	
	
	public void salvar() throws ClassNotFoundException, IOException {
		try {
			String arquivo = "save.dat";
			FileOutputStream f = new FileOutputStream(arquivo);
			ObjectOutputStream obj = new ObjectOutputStream(f);
			obj.writeObject(controllerTutor);
			obj.close();
		}catch (IOException e) {
			throw new IOException("Erro ao salvar sistema");
		}
	}
	
	public void carregar() throws ClassNotFoundException{
		try {
			String nomeArquivo = "save.dat";
			File arquivo = new File(nomeArquivo);
			if (arquivo.exists()) {
				FileInputStream f = new FileInputStream(nomeArquivo);
				ObjectInputStream obj = new ObjectInputStream(f);
				ControllerTutor controllerLido = (ControllerTutor) obj.readObject();
				this.controllerTutor = controllerLido;
				obj.close();
			}else{
				this.controllerTutor = new ControllerTutor();
			}
		}catch(IOException e) {
			throw new ClassNotFoundException("Falha na leitura");
		}
	}
	
	public void limpar() {
		this.controllerTutor = new ControllerTutor();
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
	}/**
	 * Delegacao do metodo tornarTutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia){
		this.controllerTutor.tornarTutor(controllerAluno, matricula, disciplina, proficiencia);
	}/**
	 * Delegacao do metodo recuperaTutor
	 */
	public String recuperaTutor(String matricula){
		return this.controllerTutor.recuperaTutor(matricula);
	}/**
	 * Delegacao do metodo listarTutores
	 */
	public String listarTutores(){
		return this.controllerTutor.listarTutores();
	}/**
	 * Delegacao do metodo cadastrarHorario
	 */
	public void cadastrarHorario(String email, String horario, String dia){
		this.controllerTutor.cadastrarHorario(controllerTutor, email, horario, dia);
	}/**
	 * Delegacao do metodo cadastrarLocalDeAtendimento
	 */
	public void cadastrarLocalDeAtendimento(String email, String local){
		this.controllerTutor.cadastrarLocalDeAtendimento(controllerTutor, email, local);
	}/**
	 * Delegacao do metodo consultaHorario
	 */
	public boolean consultaHorario(String email, String horario, String dia){
		return this.controllerTutor.consultaHorario(email, horario, dia);
	}/**
	 * Delegacao do metodo consultaLocal
	 */
	public boolean consultaLocal(String email, String local){
		return this.controllerTutor.consultaLocal(email, local);
	}
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse){
		return this.controllerTutor.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	public int pedirAjudaOnline (String matrAluno, String disciplina){
		return this.controllerTutor.pedirAjudaOnline(matrAluno, disciplina);
	}
	public String pegarTutor(int idAjuda){
		return this.controllerTutor.pegarTutor(idAjuda);
	}
	public String getInfoAjuda(int idAjuda, String atributo){
		return this.controllerTutor.getInfoAjuda(idAjuda, atributo);
	}
	public void avaliarTutor(int idAjuda, int nota) {
		this.controllerTutor.avaliarTutor(idAjuda, nota);
	}
	public String pegarNota(String matriculaTutor) {
		return this.controllerTutor.pegarNota(matriculaTutor);
	}
	public String pegarNivel(String matriculaTutor){
		return this.controllerTutor.pegarNivel(matriculaTutor);
	}
	public void doar(String matriculaTutor, int totalCentavos) throws Exception{
		this.controllerTutor.doar(matriculaTutor, totalCentavos);
	}
	public int totalDinheiroTutor(String emailTutor){
		return this.controllerTutor.totalDinheiroTutor(emailTutor);
	}
	public int totalDinheiroSistema(){
		return this.controllerTutor.totalDinheiroSistema();

	}
}
