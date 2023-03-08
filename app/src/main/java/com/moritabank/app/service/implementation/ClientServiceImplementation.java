package com.moritabank.app.service.implementation;

import com.moritabank.app.entity.Client;
import com.moritabank.app.repository.AccountRepository;
import com.moritabank.app.repository.ClientRepository;
import com.moritabank.app.service.ServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplementation implements ServiceClient {
    private Logger logger;

    public ClientServiceImplementation() {
        this.logger = LoggerFactory.getLogger(ClientServiceImplementation.class);
    }

    @Autowired
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client readClient(Long idClient) {
        return clientRepository.findByidClient(idClient);
    }

    @Override
    public Client UpdateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(Long idClient) {
        try {
            if (accountRepository.findByidClient(idClient) == null) {
                clientRepository.deleteById(idClient);
                logger.info("Se ha eliminado el cliente:" + idClient);
                return true;
            } else logger.error("No se ha podido eliminar el cliente con este id: " + idClient);
            return false;
        } catch (Exception ex) {
            throw ex;
        }
    }
}