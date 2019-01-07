package com.ahi.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahi.AHCustomException;
import com.ahi.entity.AhiClients;
import com.ahi.entity.AhiClients;
import com.ahi.entity.AhiClients;
import com.ahi.entity.AhiUser;
import com.ahi.model.ClientsModel;
import com.ahi.model.ClientsModel;
import com.ahi.repository.ClientsRepository;
import com.ahi.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientsRepository clientsRepository;

	@Override
	public List<ClientsModel> getAllClients() throws AHCustomException {
		try {
			List<ClientsModel> models = new ArrayList<>();
			Iterable<AhiClients> clients = clientsRepository.findAll();
			Iterator<AhiClients> iterator = clients.iterator();
			while (iterator.hasNext()) {
				ClientsModel cm = new ClientsModel();
				AhiClients client = iterator.next();
				cm.setClientId(client.getClientId());
				cm.setClientName(client.getClientName());
				cm.setClientDesc(client.getClientDesc());
				cm.setClientLocation(client.getClientLocation());
				models.add(cm);
			}
			return models;
		} catch (Exception e) {
			log.error("Error while getting Clients");
			throw new AHCustomException("Error while getting Clients");
		}
	}

	@Override
	public ClientsModel addClient(ClientsModel cm, Principal principal) throws AHCustomException {
		try {
			AhiClients clients = new AhiClients();
			clients.setClientName(cm.getClientName());
			clients.setClientDesc(cm.getClientDesc());
			clients.setClientLocation(cm.getClientLocation());
			clients.setWhoUpdated(principal.getName());
			clientsRepository.save(clients);
			cm.setClientId(clients.getClientId());
			return cm;
		} catch (Exception e) {
			log.error("Error while adding Client" + e);
			throw new AHCustomException("Error while adding Client");
		}
	}

	@Override
	public ClientsModel updateClient(ClientsModel cm, Principal principal) throws AHCustomException {
		try {
			AhiClients clients = clientsRepository.findById(cm.getClientId()).get();
			if (clients == null)
				throw new AHCustomException(
						"Error wnile udpating Client.. No Client found for Client id:::" + cm.getClientId());
			clients.setClientName(cm.getClientName());
			clients.setClientDesc(cm.getClientDesc());
			clients.setClientLocation(cm.getClientLocation());
			clients.setWhoUpdated(principal.getName());
			clientsRepository.save(clients);
			return cm;
		} catch (Exception e) {
			log.error("Error while adding Client");
			throw new AHCustomException("Error while updating Client");
		}
	}

	@Override
	public boolean deleteClient(Integer ClientId) throws AHCustomException {
		try {
			Optional<AhiClients> clients = clientsRepository.findById(ClientId);
			if (clients.isPresent())
				log.debug("The entity is present");
			else
				log.debug("The entity is not present");
			AhiClients Client = clients.get();
			clientsRepository.delete(Client);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting Clients");
			throw new AHCustomException("Error while deleting Client::" + ClientId);
		}
	}

	
}
