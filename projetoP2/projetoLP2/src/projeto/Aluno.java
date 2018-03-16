package projeto;

import java.io.Serializable;

public class Aluno implements Serializable {
	/**
	 * Atributos
	 */
	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String email;

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		if (!email.contains("@") || email.trim().equals("") || email.equals(null)
				|| email.substring(0, 1).equals("@") || email.substring(email.length()-1).equals("@")){
			throw new NullPointerException("Erro no cadastro de aluno: Email invalido");
		}
		if (nome.equals(null) || nome.trim().isEmpty()) {
			throw new NullPointerException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.email = email;
		this.codigoCurso = codigoCurso;
	}
	/**
	 * metodo acessor de nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * metodo de acessar matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * metodo que retorna a string que é o codigo do curso
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}
	/**
	 * metodo acessor do telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * metodo modificador do telefona
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * metodo acessroe que retorna a string email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * metodo modificador do email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	/**
	 * metodo que retorna a representacao textual da classe
	 */
	@Override
	public String toString() {
		String retorno = "";
		if (telefone.equals(null) || telefone.trim().equals("")) {
			retorno += matricula + " - " + nome + " - " + codigoCurso + " - " + email;
		} else {
			retorno += matricula + " - " + nome + " - " + codigoCurso + " - " + telefone + " - " + email;
		}
		return retorno;
	}

}
