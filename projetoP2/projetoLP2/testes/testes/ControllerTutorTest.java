package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerAluno;
import projeto.ControllerTutor;

public class ControllerTutorTest {

	ControllerTutor controller;
	ControllerAluno aluno;

	@Before
	public void setUp() throws Exception {
		controller = new ControllerTutor();
		aluno = new ControllerAluno();
	}

	@Test
	public void testTornarTutor() {
		aluno.cadastrarAluno("Daniel", "116210607", 22, "98485-5554", "daniel.jose.leite@ccc.ufcg.edu.br");
		controller.tornarTutor(aluno, "116210607", "P2", 5);
	}

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
}