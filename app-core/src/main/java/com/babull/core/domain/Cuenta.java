package com.babull.core.domain;

public class Cuenta {

    private final Long id;
    private Dinero saldo;

    public Cuenta(Long id, Dinero saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public void depositar(Dinero cantidad) {
        this.saldo = this.saldo.sumar(cantidad);
    }

    public void retirar(Dinero cantidad) {
        this.saldo = this.saldo.restar(cantidad);
    }

    public Long getId() {
        return id;
    }

    public Dinero getSaldo() {
        return saldo;
    }
}
