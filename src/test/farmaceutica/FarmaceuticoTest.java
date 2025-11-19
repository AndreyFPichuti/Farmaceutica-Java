package farmaceutica.test;

import farmaceutica.Farmaceutico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FarmaceuticoTest {

    @Test
    void testConstrutorCompletoEGetters() {
        Farmaceutico f = new Farmaceutico(1, "joao@example.com", "1234");

        assertEquals(1, f.getIdFarmaceutico());
        assertEquals("joao@example.com", f.getEmail());
        assertEquals("1234", f.getSenha());
    }
}