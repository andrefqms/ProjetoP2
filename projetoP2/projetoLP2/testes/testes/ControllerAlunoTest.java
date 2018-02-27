package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerAluno;

public class ControllerAlunoTest {

	ControllerAluno controller;

	@Before
	public void setUp() throws Exception {
		controller = new ControllerAluno();
	}

	@Test
	public void testCadastrarAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
	}

	@Test
	public void testRecuperaAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br",
				controller.recuperaAluno("116210607"));
		controller.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		assertEquals("115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br",
				controller.recuperaAluno("115260904"));
	}

	@Test
	public void testGetInfoAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("Daniel", controller.getInfoAluno("116210607", "nome"));
		assertEquals("daniel.jose.leite@ccc.ufcg.edu.br", controller.getInfoAluno("116210607", "EMAIL"));
		assertEquals("98485-5554", controller.getInfoAluno("116210607", "TeLeFoNe"));
	}

	@Test
	public void testListarAlunos() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		assertEquals(
				"116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br, 115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br",
				controller.listarAlunos());
	}
}
