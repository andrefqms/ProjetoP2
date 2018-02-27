package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import projeto.Tutor;

public class TutorTest {

	Tutor tutor;

	@Before
	public void ambiente() {
		this.tutor = new Tutor("fulano", "116210000", 2000, "99999-5555", "fulano@hotmail.com.br", 4);
	}

	@Test
	public void testToString() {
		assertEquals("116210000 - fulano - 2000 - 99999-5555 - fulano@hotmail.com.br", tutor.toString());
	}

	@Test
	public void testAluno() {
		assertEquals("fulano", tutor.getNome());
		assertEquals("116210000", tutor.getMatricula());
		assertEquals(2000, tutor.getCodigoCurso());
		assertEquals("99999-5555", tutor.getTelefone());
		assertEquals("fulano@hotmail.com.br", tutor.getEmail());
		assertEquals(4, tutor.getProficiencia());

	}

}
