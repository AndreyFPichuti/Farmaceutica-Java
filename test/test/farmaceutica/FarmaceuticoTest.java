package test.farmaceutica;

import farmaceutica.Farmaceutico;
import org.junit.Test;
import static org.junit.Assert.*;

public class FarmaceuticoTest {

    @Test
    public void testConstrutorCompletoEGetters() {
        Farmaceutico f = new Farmaceutico(1, "joao@example.com", "1234");

        assertEquals(1, f.getIdFarmaceutico());
        assertEquals("joao@example.com", f.getEmail());
        assertEquals("1234", f.getSenha());
    }
    
    @Test
    public void testSetters() {
        Farmaceutico f = new Farmaceutico();

        f.setIdFarmaceutico(5);
        f.setEmail("marcos@example.com");
        f.setSenha("abcd");

        assertEquals(5, f.getIdFarmaceutico());
        assertEquals("marcos@example.com", f.getEmail());
        assertEquals("abcd", f.getSenha());
    }
}