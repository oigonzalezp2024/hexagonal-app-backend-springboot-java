package com.babull.core.port.out;

import com.babull.core.domain.Cuenta;
import java.util.Optional;

public interface CuentaRepositoryPort {
    Optional<Cuenta> obtenerCuenta(Long id);
    void actualizarCuenta(Cuenta cuenta);
}
