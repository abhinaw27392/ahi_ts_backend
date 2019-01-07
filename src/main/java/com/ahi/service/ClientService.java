package com.ahi.service;

import java.security.Principal;
import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.model.ClientsModel;

public interface ClientService {

	List<ClientsModel> getAllClients() throws AHCustomException;

	ClientsModel addClient(ClientsModel clientsModel, Principal principal) throws AHCustomException;

	ClientsModel updateClient(ClientsModel clientsModel, Principal principal) throws AHCustomException;

	boolean deleteClient(Integer clientId) throws AHCustomException;
}
