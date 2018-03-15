package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerAluno;
import projeto.ControllerTutor;
import projeto.Tutor;

public class ControllerTutorTest {

	ControllerTutor controller;
	ControllerAluno aluno;

	/**
	 * ambientacao dos testes
	 */
	@Before
	public void setUp() throws Exception {
		controller = new ControllerTutor();
		aluno = new ControllerAluno();
	}

	/**
	 * testa se torna aluno em tutor
	 */
	@Test
	public void testTornarTutor() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
	}

	/**
	 * testa o meetodo de consultar o horario
	 */
	@Test
	public void testConsultaHorario() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		controller.cadastrarHorario(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "14:00", "seg");
		aluno.cadastrarAluno("José", "9999999", 22, "9696-9898", "jose.email@bol.com.br");
		controller.tornarTutor(aluno, "9999999", "LP2", 5);
		controller.cadastrarHorario(controller, "jose.email@bol.com.br", "02:00", "qui");

		assertEquals(true, controller.consultaHorario("jose.email@bol.com.br", "02:00", "qui"));
	}

	/**
	 * metodo que testa se realmente procura o tutor certo
	 */
	@Test
	public void testProcurarTutor() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br",
				controller.ProcurarTutor("116210607").toString());

	}

	/**
	 * metodo que testa se realmente retorna o tutor certo
	 */
	@Test
	public void testrecuperaTutor() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br",
				controller.recuperaTutor("116210607"));

	}

	/**
	 * metodo que testa a listagem dos tutores existentes
	 */
	@Test
	public void testlistarTutores() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		aluno.cadastrarAluno("José", "9999999", 22, "9696-9898", "jose.email@bol.com.br");
		controller.tornarTutor(aluno, "9999999", "LP2", 5);
		assertEquals(
				"9999999 - José - 22 - 9696-9898 - jose.email@bol.com.br, 116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br",
				controller.listarTutores());
	}

	/*
	 * @Test public void testProcurarTutorEmail() {
	 * aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554",
	 * "daniel.jose.leite@ccc.ufcg.edu.br"); controller.tornarTutor(aluno,
	 * "116210607", "P2", 5);
	 * assertEquals("116210607 - Daniel - 22 - 98485-5554 - daniel.jose.leite@ccc.ufcg.edu.br"
	 * , controller.ProcurarTutorEmail("daniel.jose.leite@ccc.ufcg.edu.br")); }
	 */
	/**
	 * metodo que testa se realmente cadsatrar o horario e testa o retorno
	 * booleano do consulta horario
	 */
	@Test
	public void testcadastrarHorarioEConsultaHorario() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		controller.cadastrarHorario(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "12:00", "seg");
		assertEquals(true, controller.consultaHorario("daniel.jose.leite@ccc.ufcg.edu.br", "12:00", "seg"));

	}

	/**
	 * metodo que testa se realmente cadsatrar o local e testa o retorno
	 * booleano do consulta local
	 */
	@Test
	public void testcadastrarLocalDeAtendimentoEConsultaLocal() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		controller.cadastrarHorario(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "12:00", "seg");
		controller.cadastrarLocalDeAtendimento(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "LCC3");
		assertEquals(true, controller.consultaLocal("daniel.jose.leite@ccc.ufcg.edu.br", "LCC3"));
		assertEquals("116210607",controller.matriculaTutorPresencial("P2", "12:00", "seg", "LCC3"));
		assertEquals("116210607", controller.matriculaTutorOnline("P2"));
		assertEquals(1, controller.pedirAjudaOnline("111111", "P2"));
		assertEquals("P2", controller.getInfoAjuda(1, "disciplina"));
		

	}
	
	@Test
	public void testMatriculaTutorOnline() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
		controller.cadastrarHorario(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "12:00", "seg");
		controller.cadastrarLocalDeAtendimento(controller, "daniel.jose.leite@ccc.ufcg.edu.br", "LCC3");
		assertEquals("116210607", controller.matriculaTutorOnline("P2"));
		assertEquals(1, controller.pedirAjudaOnline("111111", "P2"));
		assertEquals("Tutor - 116210607, , disciplina - P2", controller.pegarTutor(1));
		
		aluno.cadastrarAluno("Joao", "131313", 23, "98485-524554", "joaozim@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "131313", "LP2", 4);
		controller.cadastrarHorario(controller, "joaozim@ccc.ufcg.edu.br", "13:00", "ter");
		controller.cadastrarLocalDeAtendimento(controller, "joaozim@ccc.ufcg.edu.br", "CB");
		assertEquals("131313", controller.matriculaTutorOnline("LP2"));
		assertEquals(2, controller.pedirAjudaOnline("22221", "LP2"));
		assertEquals("Tutor - 131313, , disciplina - LP2", controller.pegarTutor(2));
		
	}

}