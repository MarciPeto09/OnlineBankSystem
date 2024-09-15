package org.example.clients;


import org.hibernate.SessionFactory;

import java.util.List;

public class ClientsService {
    private ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void add (ClientsEntity employee) {
        clientsRepository.add(employee);
    }

    public void remove (int id) {
        clientsRepository.remove(id);
    }


    public ClientsEntity findById (int id) {
        return clientsRepository.findById(id);
    }

    public void update (ClientsEntity object, int id) {
        clientsRepository.update(object, id);
    }

    public List<ClientsEntity> findAll () {
        return clientsRepository.findAll();
    }
}