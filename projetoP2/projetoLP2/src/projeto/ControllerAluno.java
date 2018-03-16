package projeto;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerAluno {

	private ArrayList<Aluno> alunos;

	public ControllerAluno() {
		this.alunos = new ArrayList<Aluno>();

	}
	
/**
 * metodo que ordena a listagem de acordo com o criterio
 * @param atributo
 */
	public void configurarOrdem(String atributo) {
		if (atributo.equalsIgnoreCase("email")) {
			Collections.sort(alunos, new AlunoComparatorEmail());	
		} else if (atributo.equalsIgnoreCase("matricula")) {
			Collections.sort(alunos, new AlunoComparatorMatricula());
		} else if (atributo.equalsIgnoreCase("nome")) {
			Collections.sort(alunos, new AlunoComparator());
		}

	}

	/**
	 * metodo que cadastra o aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		if (this.alunos.contains(aluno)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		this.alunos.add(aluno);
	}

	/**
	 * metodo que retorna o tostring de certo aluno
	 */
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

	/**
	 * metodo que retorna as informacoes de certo aluno
	 */
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

	/**
	 * metodo que retona o tostring de cada aluno existente
	 */
	public String listarAlunos() {
		String lista = "";
		Collections.sort(alunos, new AlunoComparator());
		for (Aluno aluno : this.alunos) {
			lista += aluno.toString() + ", ";
		}
		String retorno = lista.substring(0, lista.length() - 2);

		return retorno;
	}

	/**
	 * metodo que procura certo aluno de acordo com a matricula
	 */
	public Aluno ProcurarAluno(String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
		}
		return null;
	}

	/**
	 * metodo que procura certo aluno de acordo com o email
	 */
	public Aluno ProcurarAlunoEmail(String email) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getEmail().equals(email)) {
				return alunos.get(i);
			}
		}
		return null;
	}

	/*
	 * metodo que retorna o arrayList com os alunos
	 */
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	/*
	 * metodo que modifica o arrayList com os alunos
	 */
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

}
