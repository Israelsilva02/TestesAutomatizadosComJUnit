package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaMaiorSalario() {
        BonusService service = new BonusService();
//        assertThrows(IllegalArgumentException.class ,
//                ()->service.calcularBonus(new Funcionario("israel", LocalDate.now(), new BigDecimal("25000"))));
        try {
            service.calcularBonus(new Funcionario("israel", LocalDate.now(), new BigDecimal("25000")));
            fail("Não executou a Exception");
        } catch (Exception e) {


        }

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("israel", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("israel", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}