package com.moritabank.app.controller;

import com.moritabank.app.entity.Client;
import com.moritabank.app.service.ServiceClient;
import org.hibernate.PropertyValueException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping("/api/client")

public class ClientController {

    @Autowired
    ServiceClient serviceClient;

    private Logger logger;

    private ClientController() {
        this.logger = LoggerFactory.getLogger(ClientController.class);
    }

    @GetMapping("{clientId}")
    @ResponseBody

    public ResponseEntity<Client> readClient(@PathVariable("clientId") Long clientId) {
        Client response = null;
        HttpStatus status = null;
        String message = null;

        try {
            response = serviceClient.readClient(clientId);

            if (response != null) {
                status = HttpStatus.OK;
                message = "Cliente encontrado";
                return ResponseEntity.status(status).body(response);

            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "No  fue posible encontrar el cliente por lo tanto ha sido creado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client response = null;
        HttpStatus status = null;
        String message = null;

        try {

            response = serviceClient.createClient(client);
            //logger.debug("si funciona");
            if (response != null) {
                status = HttpStatus.BAD_REQUEST;
                message = " cliente creado Satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "No fue posible crear el cliente";
                return ResponseEntity.status(status).body(response);
            }

        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }


    @PutMapping(path = "{clientId}")
    @ResponseBody
    public ResponseEntity<Object> updateClient(@PathVariable(name = "clientId") Long clientId, Client client) {


        try {
            client.setClientId(clientId);
            logger.warning(client.getClientId().toString());
            Client newClient = this.serviceClient.UpdateClient(client);
            if (newClient != null)
                return ResponseEntity.status(HttpStatus.OK).body(newClient);
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Bad request data"));
            }
        } catch (PropertyValueException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ex.getMessage()));

        }

    }

    @DeleteMapping(params = {"idClient"})
    @ResponseBody
    public ResponseEntity deleteClient(@RequestParam("idClient") Long idClient) {

        try {
            if (serviceClient.deleteClient(idClient))
                return ResponseEntity.status(HttpStatus.OK).body(new Error("El cliente se elimino correctamente"));
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error("El cliente no se pudo eliminar"));

        } catch (Exception ex) {
            logger.warning("Exception" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ex.getMessage()));
        }
    }


    class Error {
        public String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}