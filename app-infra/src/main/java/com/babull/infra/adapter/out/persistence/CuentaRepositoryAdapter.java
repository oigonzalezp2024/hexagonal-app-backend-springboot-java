package com.babull.infra.adapter.out.persistence;

import java.util.Optional;
import org.springframework.stereotype.Component;

// Imports del Core
import com.babull.core.domain.Cuenta;
import com.babull.core.domain.Dinero;
import com.babull.core.port.out.CuentaRepositoryPort;

// Imports de la Infraestructura
import com.babull.infra.adapter.out.persistence.entity.CuentaJpaEntity;
import com.babull.infra.adapter.out.persistence.springdata.CuentaJpaRepository;

@Component
public class CuentaRepositoryAdapter implements CuentaRepositoryPort {

    private final CuentaJpaRepository jpaRepository;

    public CuentaRepositoryAdapter(CuentaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Cuenta> obtenerCuenta(Long id) {
        // Petición a la DB
        Optional<CuentaJpaEntity> entityOptional = jpaRepository.findById(id);

        // Traducción de CuentaJpaEntity a Cuenta de Dominio
        return entityOptional.map(entity ->
                new Cuenta(entity.getId(), Dinero.de(entity.getSaldo().doubleValue()))
        );
    }

    @Override
    public void actualizarCuenta(Cuenta cuenta) {
        // Traducción de Cuenta de Dominio a CuentaJpaEntity
        CuentaJpaEntity entity = new CuentaJpaEntity(
                cuenta.getId(),
                cuenta.getSaldo().getCantidad()
        );

        // Guardar en la DB
        jpaRepository.save(entity);
        System.out.println("LOG (MySQL): Cuenta " + cuenta.getId() + " persistida. Nuevo saldo: " + cuenta.getSaldo().getCantidad());
    }
}
