package com.babull.core.service;

import com.babull.core.domain.Cuenta;
import com.babull.core.domain.Dinero;
import com.babull.core.port.out.CuentaRepositoryPort;
import com.babull.core.port.in.TransferenciaServicePort;
import org.springframework.stereotype.Service; // <-- CORRECCIÓN: Para que Spring lo reconozca como Bean

@Service
public class TransferenciaService implements TransferenciaServicePort {

    private final CuentaRepositoryPort cuentaRepository;

    public TransferenciaService(CuentaRepositoryPort cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void transferir(Long origenId, Long destinoId, double monto) {

        Dinero cantidad = Dinero.de(monto);

        Cuenta cuentaOrigen = cuentaRepository.obtenerCuenta(origenId)
                .orElseThrow(() -> new RuntimeException("Cuenta de origen no encontrada"));

        Cuenta cuentaDestino = cuentaRepository.obtenerCuenta(destinoId)
                .orElseThrow(() -> new RuntimeException("Cuenta de destino no encontrada"));

        cuentaOrigen.retirar(cantidad);
        cuentaDestino.depositar(cantidad);

        cuentaRepository.actualizarCuenta(cuentaOrigen);
        cuentaRepository.actualizarCuenta(cuentaDestino);
    }
}
