package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sistema {
	
	private int total;
	ControllerAluno controllerAluno;
	ControllerTutor controllerTutor;
	private ArrayList<Tutor> tutoresAssociados;
	private ArrayList<Ajuda> pedidos;

	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerTutor = new ControllerTutor();
		this.tutoresAssociados = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.total = 0;
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

	public String avaliarTutor(int idAjuda, int nota)throws IllegalArgumentException {
		if(nota < 0){
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}if(nota > 5.0){
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}if(tutoresAssociados.size() < idAjuda){
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		if(tutoresAssociados.get(idAjuda-1).getAvaliacao() != 0){
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		
		
		
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
				return tutor.getNivel();
			}
		}
		return "";
	}
	
	
	public int getTotal() {
		return total;
	}

	public double calculoDinheiro(String matriculaTutor, int totalCentavos,double nota, double nivel_porcento){
		double total;
		if(controllerTutor.ProcurarTutor(matriculaTutor).getAvaliacao() == nota){
			return total  = (1 - nivel_porcento) * totalCentavos ;
		}else{
			return calculoDinheiro( matriculaTutor, totalCentavos,nota + 0.1,nivel_porcento + 0.01);
		}
		
	}
	public double calculoDinheiro2(String matriculaTutor, int totalCentavos,double nota, double nivel_porcento){
		double total;
		if(controllerTutor.ProcurarTutor(matriculaTutor).getAvaliacao() == nota){
			return total  = (1 - nivel_porcento) * totalCentavos ;
		}else{
			return calculoDinheiro( matriculaTutor, totalCentavos,nota - 0.1,nivel_porcento - 0.01);
		}
		
	}
	public void doar(String matriculaTutor, int totalCentavos)throws IllegalArgumentException{
		if(controllerTutor.ProcurarTutor(matriculaTutor) == null){
			throw new IllegalArgumentException("Erro na doacao para tutor: Tutor nao encontrado");
		}
		if(totalCentavos < 0){
			throw new IllegalArgumentException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
		if(controllerTutor.ProcurarTutor(matriculaTutor).getAvaliacao() >= 4.5){
			total += calculoDinheiro(matriculaTutor, totalCentavos, 4.5, 0.9);
			controllerTutor.ProcurarTutor(matriculaTutor).setDinheiro(totalCentavos - total);
		}else if(controllerTutor.ProcurarTutor(matriculaTutor).getAvaliacao() > 3.0 && controllerTutor.ProcurarTutor(matriculaTutor).getAvaliacao() < 4.5){
			total += (1 - 0.8) * totalCentavos ;
			controllerTutor.ProcurarTutor(matriculaTutor).setDinheiro(totalCentavos - total);
		}else{
			total +=  calculoDinheiro2(matriculaTutor, totalCentavos, 3.0, 0.3);
			controllerTutor.ProcurarTutor(matriculaTutor).setDinheiro(totalCentavos - total);
		}
		
	}
	public int totalDinheiroTutor(String emailTutor)throws IllegalArgumentException{
		if(emailTutor.trim().equals("") || emailTutor.equals(null)){
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		}if(controllerTutor.ProcurarTutorEmail(emailTutor) == null){
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
		}
		return (int) controllerTutor.ProcurarTutorEmail(emailTutor).getDinheiro();
	}
	public int totalDinheiroSistema(){
		return getTotal();
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
