package com.babull.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Dinero {

    private final BigDecimal cantidad;

    private Dinero(BigDecimal cantidad) {
        if (cantidad.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public static Dinero de(double valor) {
        return new Dinero(BigDecimal.valueOf(valor));
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public Dinero sumar(Dinero otro) {
        return new Dinero(this.cantidad.add(otro.cantidad));
    }

    public Dinero restar(Dinero otro) {
        BigDecimal resultado = this.cantidad.subtract(otro.cantidad);
        if (resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        return new Dinero(resultado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinero dinero = (Dinero) o;
        return Objects.equals(cantidad, dinero.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }
}
