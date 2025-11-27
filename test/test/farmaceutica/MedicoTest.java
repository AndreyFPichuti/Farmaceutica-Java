package test.farmaceutica;

import farmaceutica.Medico;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedicoTest {

    @Test
    public void testConstrutorCompletoEGetters() {
        Medico m = new Medico("andreymed@example.com", "1234");

        assertEquals("andreymed@example.com", m.getEmail());
        assertEquals("1234", m.getSenha());
    }
    
    @Test
    public void testSetters() {
        Medico m = new Medico();

        m.setEmail("marcosmed@example.com");
        m.setSenha("abcd");

        assertEquals("marcosmed@example.com", m.getEmail());
        assertEquals("abcd", m.getSenha());
    }
}