package test.farmaceutica;

import farmaceutica.Paciente;
import farmaceutica.Medico;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacienteTest {

    @Test
    public void testConstrutorCompletoEGetters() {
        Medico m = new Medico();
        Paciente p = new Paciente("Maria", "11122233344", 1, m);
        
        assertEquals("Maria", p.getNome());
        assertEquals("11122233344", p.getCpf());
        assertEquals(1, p.getIdMedico());
        assertEquals(m, p.getMedico());
    }

    @Test
    public void testSetters() {
        Paciente p = new Paciente();
        Medico m = new Medico();
        
        p.setNome("Gabriel");
        p.setCpf("99988877766");
        p.setIdMedico(1);
        p.setMedico(m);

        
        assertEquals("Gabriel", p.getNome());
        assertEquals("99988877766", p.getCpf());
        assertEquals(1, p.getIdMedico());
        assertEquals(m, p.getMedico());
    }
}