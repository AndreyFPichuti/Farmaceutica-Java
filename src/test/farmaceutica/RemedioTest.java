package test.farmaceutica;

import farmaceutica.Remedio;
import farmaceutica.Farmaceutico;
import farmaceutica.Paciente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class RemedioTest {

    @Test
    void testConstrutorCompletoEGetters() {
        Farmaceutico f = new Farmaceutico(1,  "joao@example.com", "senha123");
        Remedio r = new Remedio(
            1, 10, "Paracetamol", 50, "Oral", "Dor de cabeça",
            "Alergia", "Paracetamol", "Náusea", "Comprimido", "2025-12-31", f
        );

        assertEquals(1, r.getIdFarmaceutico());
        assertEquals(10, r.getIdRemedio());
        assertEquals("Paracetamol", r.getNome());
        assertEquals(50, r.getEstoque());
        assertEquals("Oral", r.getViaMedicacao());
        assertEquals("Dor de cabeça", r.getIndicacoes());
        assertEquals("Alergia", r.getContraindicacoes());
        assertEquals("Paracetamol", r.getPrincipalAtivo());
        assertEquals("Náusea", r.getEfeitosColaterais());
        assertEquals("Comprimido", r.getFormaFarmaceutica());
        assertEquals("2025-12-31", r.getValidade());
        assertEquals(f, r.getFarmaceutico());
        assertNotNull(r.getPacientes());
    }

    @Test
    void testSetters() {
        Remedio r = new Remedio();
        Farmaceutico f = new Farmaceutico(2, "gabriel@example.com", "senha");

        r.setIdFarmaceutico(2);
        r.setIdRemedio(20);
        r.setNome("Ibuprofeno");
        r.setEstoque(100);
        r.setViaMedicacao("Oral");
        r.setIndicacoes("Inflamação");
        r.setContraindicacoes("Úlcera");
        r.setPrincipalAtivo("Ibuprofeno");
        r.setEfeitosColaterais("Tontura");
        r.setFormaFarmaceutica("Cápsula");
        r.setValidade("2026-01-01");
        r.setFarmaceutico(f);

        assertEquals(2, r.getIdFarmaceutico());
        assertEquals(20, r.getIdRemedio());
        assertEquals("Ibuprofeno", r.getNome());
        assertEquals(100, r.getEstoque());
        assertEquals("Oral", r.getViaMedicacao());
        assertEquals("Inflamação", r.getIndicacoes());
        assertEquals("Úlcera", r.getContraindicacoes());
        assertEquals("Ibuprofeno", r.getPrincipalAtivo());
        assertEquals("Tontura", r.getEfeitosColaterais());
        assertEquals("Cápsula", r.getFormaFarmaceutica());
        assertEquals("2026-01-01", r.getValidade());
        assertEquals(f, r.getFarmaceutico());
    }

}
