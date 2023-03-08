package com.moritabank.app.service;

import com.moritabank.app.entity.Client;

 public interface ServiceClient {
    Client createClient (Client client);

    Client readClient (Long idClient);
    Client UpdateClient( Client client);

  boolean deleteClient (Long idClient);


}
