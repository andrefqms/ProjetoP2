package projeto;

import java.util.HashSet;

public class ControllerTutor {

	private HashSet<Tutor> tutores;

	public ControllerTutor() {
		this.tutores = new HashSet<>();
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
	public void cadastrarHorario(ControllerTutor controllerTutor, String email, String horario, String dia) throws IllegalArgumentException{
		if(dia.trim().equals("") || dia == null){
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		if(horario.trim().equals("") || horario == null){
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if(email.trim().equals("") || email == null){
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		if(ProcurarTutorEmail(email) == null){
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
	public void cadastrarLocalDeAtendimento(ControllerTutor controllerTutor,String email, String local) throws IllegalArgumentException{
		if(local.trim().equals("") || local == null){
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if(email.trim().equals("") || email == null){
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		if(ProcurarTutorEmail(email) == null){
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

}
