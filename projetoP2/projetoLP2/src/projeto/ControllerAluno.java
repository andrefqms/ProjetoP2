package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class ControllerAluno {

	private ArrayList<Aluno> alunos;
	private HashSet<Tutor> tutores;

	public ControllerAluno() {
		this.alunos = new ArrayList<Aluno>();
		this.tutores = new HashSet<Tutor>();

	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		if (this.alunos.contains(aluno)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		this.alunos.add(aluno);
	}

	public String recuperaAluno(String matricula) {
		String retorno = "";
		for (int i = 0; i < this.alunos.size(); i++) {
			if (this.alunos.get(i).getMatricula().equals(matricula)) {
				retorno += this.alunos.get(i).toString();
			}
		}
		if (retorno.equals("")) {
			throw new NullPointerException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return retorno;
	}

	public String getInfoAluno(String matricula, String atributo) {
		String retorno = "";

		for (int i = 0; i < this.alunos.size(); i++) {
			if (atributo.equalsIgnoreCase("nome") && matricula.equals(this.alunos.get(i).getMatricula())) {
				retorno += this.alunos.get(i).getNome();
			} else if (atributo.equalsIgnoreCase("email") && matricula.equals(this.alunos.get(i).getMatricula())) {
				retorno += this.alunos.get(i).getEmail();
			} else if (atributo.equalsIgnoreCase("telefone") && matricula.equals(this.alunos.get(i).getMatricula())) {
				retorno += this.alunos.get(i).getTelefone();
			}
		}
		if (retorno.equals("")) {
			throw new NullPointerException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		return retorno;
	}

	public String listarAlunos() {
		String lista = "";
		Collections.sort(alunos, new AlunoComparator());
		for (Aluno aluno : this.alunos) {
			lista += aluno.toString() + ", ";
		}
		String retorno = lista.substring(0, lista.length() - 2);

		return retorno;
	}

	public Aluno ProcurarAluno(String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
		} 
		return null;
	}
	public Tutor ProcurarTutor(String matricula) {
		for (Tutor tutor : tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				return tutor;
			}
		}
		return null;
	}
	public void tornarTutor(String matricula, String disciplina, int proficiencia)  {
		if(proficiencia <= 0){
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
	
		Tutor tutor = new Tutor(ProcurarAluno(matricula).getNome(), ProcurarAluno(matricula).getMatricula(),
				ProcurarAluno(matricula).getCodigoCurso(), ProcurarAluno(matricula).getTelefone(),
				ProcurarAluno(matricula).getEmail(), disciplina, proficiencia);
		tutores.add(tutor);
		
		
	}

	public String recuperaTutor(String matricula) throws IllegalArgumentException{
		String msg = "";			
		if(ProcurarTutor(matricula) == null){
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

}
