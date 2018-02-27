package projeto;

import java.util.HashSet;

public class ControllerTutor {

	private HashSet<Tutor> tutores;

	public ControllerTutor() {
		this.tutores = new HashSet<>();
	}

	public Tutor ProcurarTutor(String matricula) {
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				return tutor;
			}
		}
		return null;
	}

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

	public String listarTutores() {
		String msg = "";
		for (Tutor tutor : tutores) {
			msg += tutor.toString() + ", ";

		}
		String retorno = msg.substring(0, msg.length() - 2);

		return retorno;
	}

	public void cadastrarHorario(ControllerTutor controllerTutor, String email, String horario, String dia) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email)) {
				tutor.getDias().add(dia);
				tutor.getHorarios().add(horario);
			}
		}
	}

	public void cadastrarLocalDeAtendimento(ControllerTutor controllerTutor, String email, String local) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email)) {
				tutor.setLocal(local);
			}
		}
	}

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

	public boolean consultaLocal(String email, String local) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equalsIgnoreCase(email) && tutor.getLocal().equalsIgnoreCase(local)) {
				return true;
			}
		}
		return false;

	}

}
