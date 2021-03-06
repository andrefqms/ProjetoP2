package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.Aluno;

public class AlunoTest {

	Aluno aluno;
	/**
	 * Ambientacao dos testes
	 */
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("Daniel", "116210888", 2500, "99888-5545", "danielzinho123@bol.com.br");
	}
	/**
	 * testa os atributos da classe aluno
	 */
	@Test
	public void testAluno() {
		assertEquals("Daniel", aluno.getNome());
		assertEquals("116210888", aluno.getMatricula());
		assertEquals(2500, aluno.getCodigoCurso());
		assertEquals("99888-5545", aluno.getTelefone());
		assertEquals("danielzinho123@bol.com.br", aluno.getEmail());
	}
	/**
	 * testa a representacao textual da classe
	 */
	@Test
	public void testToString() {
		assertEquals("116210888 - Daniel - 2500 - 99888-5545 - danielzinho123@bol.com.br", aluno.toString());
	}
}
