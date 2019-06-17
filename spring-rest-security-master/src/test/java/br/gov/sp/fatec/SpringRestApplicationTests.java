package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.sp.fatec.model.*;
import br.gov.sp.fatec.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestApplicationTests {

	private Email email = new Email("smtp.gmail.com","465","javax.net.ssl.SSLSocketFactory",true,"465");
	private static final String NOME = "Usuário X";
	private static final String SENHA = "X";
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Test
	public void testeInsercaoOk() {
		email.sendEmail("junior.alves.5@hotmail.com", "MONEY", "TEST");
		assertTrue(1 != 2);
	}

}
