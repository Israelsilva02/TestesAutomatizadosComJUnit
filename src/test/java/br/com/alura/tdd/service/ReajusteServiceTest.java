package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void iniciar() {
        System.out.println("Inicializar");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("israel", LocalDate.now(), new BigDecimal("1000"));
    }
    @AfterEach
    public void finalizar(){
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos");
    }
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de todos");
    }

    @Test
    public void reajusteDeveSerDe3PorCentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, Desempemho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDe15PorCentoQuandoDesempenhoForBom() {
        reajusteService.concederReajuste(funcionario, Desempemho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDe20PorCentoQuandoDesempenhoForOtimo() {
        reajusteService.concederReajuste(funcionario, Desempemho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDe40PorCentoQuandoDesempenhoForExcelente() {
        reajusteService.concederReajuste(funcionario, Desempemho.EXCELENTE);
        assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
    }
}
