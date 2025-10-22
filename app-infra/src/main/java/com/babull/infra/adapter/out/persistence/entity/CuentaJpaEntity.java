package com.babull.infra.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta")
public class CuentaJpaEntity {

    @Id
    private Long id;
    private BigDecimal saldo;

    public CuentaJpaEntity() {
    }

    public CuentaJpaEntity(Long id, BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    // Getters y Setters requeridos por JPA
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
