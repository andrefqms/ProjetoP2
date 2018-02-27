package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerAluno;

public class ControllerAlunoTest {

	ControllerAluno controller;
	/**
	 * ambientacao dos testes
	 */
	@Before
	public void setUp() throws Exception {
		controller = new ControllerAluno();
	}
	/**
	 * testa se realmente cadastra
	 */
	@Test
	public void testCadastrarAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
	}
	/**
	 * testa se recupera certo aluno
	 */
	@Test
	public void testRecuperaAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br",
				controller.recuperaAluno("116210607"));
		controller.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		assertEquals("115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br",
				controller.recuperaAluno("115260904"));
	}
	/**
	 * testa se a informacoes do aluno estao certas
	 */
	@Test
	public void testGetInfoAluno() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("Daniel", controller.getInfoAluno("116210607", "nome"));
		assertEquals("daniel.jose.leite@ccc.ufcg.edu.br", controller.getInfoAluno("116210607", "EMAIL"));
		assertEquals("98485-5554", controller.getInfoAluno("116210607", "TeLeFoNe"));
	}
	/**
	 * testa se a listagem de alunos esta certo
	 */
	@Test
	public void testListarAlunos() {
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		assertEquals(
				"116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br, 115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br",
				controller.listarAlunos());
	}
	/**
	 * testa se realmente Procura certo aluno pela matricula
	 */
	@Test
	public void testProcurarAluno(){
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br", controller.ProcurarAluno("116210607").toString());
	}
	/**
	 * testa se realmente Procura certo aluno pelo email
	 */
	@Test
	public void testProcurarAlunoEmail(){
		controller.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br", controller.ProcurarAlunoEmail("daniel.jose.leite@ccc.ufcg.edu.br").toString());
	}
}
