package com.babull.core.port.in;

public interface TransferenciaServicePort {
    void transferir(Long origenId, Long destinoId, double monto);
}
