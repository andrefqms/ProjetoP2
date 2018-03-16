package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class ControllerTutor implements Serializable {

	private HashSet<Tutor> tutores;
	private HashMap<Integer, Ajuda> pedidos;
	private int total;;

	public ControllerTutor() {
		this.tutores = new HashSet<Tutor>();
		this.pedidos = new HashMap<Integer, Ajuda>();
		this.total = 0;
	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) throws IllegalArgumentException {
		String matriculaTutor = matriculaTutorPresencial(disciplina, horario, dia, localInteresse);
		int id = this.pedidos.size() + 1;
		AjudaPresencial ajuda = new AjudaPresencial(id, matrAluno, disciplina, horario, dia, localInteresse,
				matriculaTutor);
		pedidos.put(id, ajuda);
		ajuda.setMatriculaTutor(matriculaTutor);
		return id;
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) throws IllegalArgumentException {
		String matriculaTutor = matriculaTutorOnline(disciplina);
		int id = this.pedidos.size() + 1;
		AjudaOnline ajuda = new AjudaOnline(id, matrAluno, disciplina, matriculaTutor);
		pedidos.put(id, ajuda);
		ajuda.setMatriculaTutor(matriculaTutor);
		return id;
	}

	public String matriculaTutorPresencial(String disciplina, String horario, String dia, String localInteresse) {
		String matricula = "";

		for (Tutor tutor : this.tutores) {
			int contador = 0;

			if (tutor.getDisciplinas().contains(disciplina)) {
				if (tutor.getDias().get(contador).equals(dia) && tutor.getHorarios().get(contador).equals(horario)
						&& tutor.getLocal().equals(localInteresse))
					matricula = tutor.getMatricula();

			}
			contador++;
		}
		return matricula;
	}

	public String matriculaTutorOnline(String disciplina) {
		String matricula = "";
		for (Tutor tutor : this.tutores) {
			if (tutor.getDisciplinas().contains(disciplina)) {
				matricula = tutor.getMatricula();

			}
		}

		return matricula;
	}

	public String pegarTutor(int idAjuda) throws IllegalArgumentException {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		if (idAjuda > pedidos.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return "Tutor - " + pedidos.get(idAjuda).getMatriculaTutor() + ", " + pedidos.get(idAjuda).toString();
	}

	public String getInfoAjuda(int idAjuda, String atributo) throws IllegalArgumentException {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (atributo.trim().equals("") || atributo.equals(null)) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		if (idAjuda > pedidos.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		if (!atributo.equalsIgnoreCase("disciplina") && !atributo.equalsIgnoreCase("horario")
				&& !atributo.equalsIgnoreCase("dia") && !atributo.equalsIgnoreCase("localInteresse")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		String retorno = "";
		if (atributo.equalsIgnoreCase("disciplina")) {
			retorno = pedidos.get(idAjuda).getDisciplina();
		} else if (atributo.equalsIgnoreCase("dia")) {
			retorno = ((AjudaPresencial) pedidos.get(idAjuda)).getDia();
		} else if (atributo.equalsIgnoreCase("horario")) {
			retorno = ((AjudaPresencial) pedidos.get(idAjuda)).getHorario();
		} else if (atributo.equalsIgnoreCase("localInteresse")) {
			retorno = ((AjudaPresencial) pedidos.get(idAjuda)).getLocalInteresse();
		}
		return retorno;
	}

	public void avaliarTutor(int idAjuda, int nota) throws IllegalArgumentException {
		if (nota < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if (nota > 5.0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		if (pedidos.size() < idAjuda) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		if (pedidos.get(idAjuda).getAvaliado() == true) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}

		String matricula = pedidos.get(idAjuda).getMatriculaTutor();
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				tutor.setAvaliacao((tutor.getAvaliacao() * 5 + nota) / 6);
			}
		}

		pedidos.get(idAjuda).setAvaliado(true);
		// return tutoresAssociados.get(idAjuda - 1).getMatricula();
	}

	public String pegarNota(String matriculaTutor) {
		String nota = "";
		for (Tutor tutor : getTutores()) {
			if (tutor.getMatricula().equals(matriculaTutor)) {
				nota = String.format("%.2f", tutor.getAvaliacao());
			}
		}

		return nota;
	}

	public String pegarNivel(String matriculaTutor) {
		String retorno = "";
		for (Tutor tutor : getTutores()) {
			if (tutor.getMatricula().equals(matriculaTutor)) {
				if (tutor.getAvaliacao() > 4.5) {
					retorno = "TOP";
					tutor.setNivel(retorno);
				} else if (tutor.getAvaliacao() > 3 && tutor.getAvaliacao() <= 4.5) {
					retorno = "Tutor";
					tutor.setNivel(retorno);
				} else if (tutor.getAvaliacao() > 0 && tutor.getAvaliacao() <= 3.0) {
					retorno = "Aprendiz";
					tutor.setNivel(retorno);
				}

			}
		}
		return retorno;
	}

	public int getTotal() {
		return total;
	}

	public void doar(String matriculaTutor, int totalCentavos) throws Exception {

		if (totalCentavos < 0) {
			throw new IllegalArgumentException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}

		if (!tutores.contains(ProcurarTutor(matriculaTutor))) {
			throw new NullPointerException("Erro na doacao para tutor: Tutor nao encontrado");
		}

		Double totalSistema = 0.0;
		int totalTutor = 0;
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matriculaTutor)) {
				if (tutor.getNivel().equalsIgnoreCase("top")) {
					double taxa = 0.9 + 0.01 * (tutor.getAvaliacao() - 4.5);
					totalSistema = Math.ceil((1 - taxa) * totalCentavos);
					totalTutor = (int) (totalCentavos - totalSistema);
					tutor.setDinheiro(totalTutor);
				} else if (tutor.getNivel().equalsIgnoreCase("tutor")) {
					double taxa = 0.8;
					totalSistema = Math.ceil((1 - taxa) * totalCentavos);
					totalTutor = (int) (totalCentavos - totalSistema);
					tutor.setDinheiro(totalTutor);
				} else if (tutor.getNivel().equalsIgnoreCase("aprendiz")) {
					double taxa = 0.4 - (3.0 - tutor.getAvaliacao());
					totalSistema = Math.ceil((1 - taxa) * totalCentavos);
					totalTutor = (int) (totalCentavos - totalSistema);
					tutor.setDinheiro(totalTutor);
				}
			}
		}

		total += totalSistema;

	}

	public int totalDinheiroTutor(String emailTutor) throws IllegalArgumentException {
		if (emailTutor.trim().equals("") || emailTutor.equals(null)) {
			throw new IllegalArgumentException(
					"Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		}
		if (ProcurarTutorEmail(emailTutor) == null) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
		}

		return (int) ProcurarTutorEmail(emailTutor).getDinheiro();
	}

	public int totalDinheiroSistema() {
		return getTotal();
	}

	/**
	 * Metodo que procura certo tutor e retorna ele
	 */
	public Tutor ProcurarTutor(String matricula) {
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				return tutor;
			}
		}
		return null;
	}

	/**
	 * Metodo que procura certo tutor que tem tal disciplina e retorna ele
	 */
	public ArrayList<Tutor> ProcurarTutorDisciplina(String disciplina) {
		ArrayList<Tutor> lista = new ArrayList<>();
		for (Tutor tutor : tutores) {
			if (tutor.getDisciplinas().contains(disciplina)) {
				lista.add(tutor);
			}
		}
		return lista;
	}

	/**
	 * metodo que torna um aluno em tutor
	 */
	public void tornarTutor(ControllerAluno controllerAluno, String matricula, String disciplina, int proficiencia) {
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}

		if (controllerAluno.ProcurarAluno(matricula) == null) {
			throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
		}

		Tutor tutor = new Tutor(controllerAluno.ProcurarAluno(matricula).getNome(),
				controllerAluno.ProcurarAluno(matricula).getMatricula(),
				controllerAluno.ProcurarAluno(matricula).getCodigoCurso(),
				controllerAluno.ProcurarAluno(matricula).getTelefone(),
				controllerAluno.ProcurarAluno(matricula).getEmail(), proficiencia);
		tutor.getDisciplinas().add(disciplina);
		for (Tutor tutor2 : tutores) {
			if (tutor2.getMatricula().equals(matricula) && tutor2.getDisciplinas().contains(disciplina)) {
				throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
			}
		}

		tutores.add(tutor);
		controllerAluno.getAlunos().remove(tutor);

	}

	/**
	 * metodo que retorna o tostring de um certo tutor
	 */
	public String recuperaTutor(String matricula) throws IllegalArgumentException {
		String msg = "";
		if (ProcurarTutor(matricula) == null) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				msg += tutor.toString();
			}
		}

		return msg;
	}

	/**
	 * metodo que retorna a lista de co mo tostring de cada tutor
	 */
	public String listarTutores() {
		String msg = "";
		for (Tutor tutor : tutores) {
			msg += tutor.toString() + ", ";

		}
		String retorno = msg.substring(0, msg.length() - 2);

		return retorno;
	}

	/**
	 * metodo que retorna um certo tutor de acordo com o email
	 */
	public Tutor ProcurarTutorEmail(String email) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equals(email)) {
				return tutor;
			}
		}
		return null;
	}

	/**
	 * Metodo que cadastra o horario de atendimento
	 */
	public void cadastrarHorario(ControllerTutor controllerTutor, String email, String horario, String dia)
			throws IllegalArgumentException {
		if (dia.trim().equals("") || dia == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if (email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		if (ProcurarTutorEmail(email) == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}

		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email)) {
				tutor.getDias().add(dia);
				tutor.getHorarios().add(horario);
			}
		}
	}

	/**
	 * metodo que cadastra o local de atendimento
	 */
	public void cadastrarLocalDeAtendimento(ControllerTutor controllerTutor, String email, String local)
			throws IllegalArgumentException {
		if (local.trim().equals("") || local == null) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if (email.trim().equals("") || email == null) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		if (ProcurarTutorEmail(email) == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email)) {
				tutor.setLocal(local);
			}
		}
	}

	/**
	 * metodo que retorna true se possui certo horario de atendimento e false se nao
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email)) {
				for (int i = 0; i < tutor.getDias().size(); i++) {
					if (tutor.getDias().get(i).equals(dia) && tutor.getHorarios().get(i).equals(horario)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * metodo que retorna true se possui certo local de atendimento e false se nao
	 */
	public boolean consultaLocal(String email, String local) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email) && tutor.getLocal().equalsIgnoreCase(local)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * metodo acessor do arraylist com os tutores
	 * 
	 * @return os tutores
	 */
	public HashSet<Tutor> getTutores() {
		return tutores;
	}

	/**
	 * metodo que ao receber uma lista com tutores , procura o que tem melhor
	 * proficiencia e e retorna esse tal tutor
	 */
	public Tutor ProcurarTutorProficiencia(ArrayList<Tutor> lista) {
		Collections.sort(lista);
		return lista.get(0);
	}

}
