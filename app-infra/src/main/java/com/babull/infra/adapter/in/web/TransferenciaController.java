package com.babull.infra.adapter.in.web;

import com.babull.core.port.in.TransferenciaServicePort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


class TransferenciaRequest {
    public Long origenId;
    public Long destinoId;
    public double monto;
}


@RestController
@RequestMapping("/api/v1/transferencia")
public class TransferenciaController {

    private final TransferenciaServicePort transferenciaService;

    public TransferenciaController(TransferenciaServicePort transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<String> transferir(@RequestBody TransferenciaRequest request) {
        try {
            transferenciaService.transferir(
                    request.origenId,
                    request.destinoId,
                    request.monto
            );
            return new ResponseEntity<>("Transferencia realizada con éxito.", HttpStatus.OK);

        } catch (RuntimeException e) {
            // Devuelve el mensaje de error de negocio (ej: "Saldo insuficiente.")
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
