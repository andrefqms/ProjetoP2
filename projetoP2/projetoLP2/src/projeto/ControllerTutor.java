package projeto;

import java.util.ArrayList;
import java.util.HashSet;

public class ControllerTutor {

	private HashSet<Tutor> tutores;
	private ArrayList<Tutor> horarios;
	private ArrayList<Tutor> locais;

	public ControllerTutor() {
		this.tutores = new HashSet<>();
		this.locais = new ArrayList<>();
		this.horarios = new ArrayList<>();

	}

	public Tutor ProcurarTutor(String matricula) {
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				return tutor;
			}
		}
		return null;
	}

	public Tutor ProcurarTutorEmail(String email) {
		for (Tutor tutor : tutores) {
			if (tutor.getEmail().equals(email)) {
				return tutor;
			}
		}
		return null;
	}

	public void tornarTutor(ControllerAluno controllerAluno, String matricula, String disciplina, int proficiencia) {
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}

		Tutor tutor = new Tutor(controllerAluno.ProcurarAluno(matricula).getNome(),
				controllerAluno.ProcurarAluno(matricula).getMatricula(),
				controllerAluno.ProcurarAluno(matricula).getCodigoCurso(),
				controllerAluno.ProcurarAluno(matricula).getTelefone(),
				controllerAluno.ProcurarAluno(matricula).getEmail(), disciplina, proficiencia);
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
		Tutor tutor = new Tutor(controllerTutor.ProcurarTutorEmail(email).getNome(),
				controllerTutor.ProcurarTutorEmail(email).getMatricula(),
				controllerTutor.ProcurarTutorEmail(email).getCodigoCurso(),
				controllerTutor.ProcurarTutorEmail(email).getTelefone(),
				controllerTutor.ProcurarTutorEmail(email).getEmail(), ProcurarTutorEmail(email).getDisciplina(),
				ProcurarTutorEmail(email).getProficiencia());
		tutor.setDia(dia);
		tutor.setHorario(horario);
		horarios.add(tutor);

	}

	public void cadastrarLocalDeAtendimento(ControllerTutor controllerTutor,String email, String local) {
		Tutor tutor = new Tutor(controllerTutor.ProcurarTutorEmail(email).getNome(),
				controllerTutor.ProcurarTutorEmail(email).getMatricula(),
				controllerTutor.ProcurarTutorEmail(email).getCodigoCurso(),
				controllerTutor.ProcurarTutorEmail(email).getTelefone(),
				controllerTutor.ProcurarTutorEmail(email).getEmail(), ProcurarTutorEmail(email).getDisciplina(),
				ProcurarTutorEmail(email).getProficiencia());
		tutor.setLocal(local);
		locais.add(tutor);
	}

	public boolean consultaHorario(String email, String horario, String dia) {

	}

	public boolean consultaLocal(String email, String local) {

	}

}
