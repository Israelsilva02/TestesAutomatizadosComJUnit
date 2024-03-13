package br.com.alura.tdd.service;

import java.math.BigDecimal;

public enum Desempemho {
    A_DESEJAR{
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    },
    EXCELENTE{
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.4");
        }
    };

    public abstract BigDecimal percentualReajuste();
}
