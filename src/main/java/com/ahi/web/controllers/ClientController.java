package com.ahi.web.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahi.AHCustomException;
import com.ahi.model.ClientsModel;
import com.ahi.service.ClientService;

@RequestMapping("/api/clients")
@RestController()
public class ClientController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientsModel>> getAllClients() {

		try {
			List<ClientsModel> models = clientService.getAllClients();
			return new ResponseEntity<List<ClientsModel>>(models, HttpStatus.OK);
		} catch (AHCustomException e) {
			throw new WebServerException(e.getErrorMessage(), e);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ClientsModel> saveClient(@RequestBody ClientsModel clientsModel, Principal principal)
			throws Exception {
		try {
			log.debug("username is:" + principal.getName() );
			if (clientsModel.getClientId() == null || clientsModel.getClientId() == 0)
				clientsModel = clientService.addClient(clientsModel, principal);
			else
				clientsModel = clientService.updateClient(clientsModel, principal);
		} catch (AHCustomException e) {
			throw new WebServerException(e.getErrorMessage(), e);
		}
		return new ResponseEntity<ClientsModel>(clientsModel, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteClient(@RequestParam(value = "clientIds") Integer[] clientIds) {
		try {
			for (Integer clientId : clientIds) {
				clientService.deleteClient(clientId);

			}
			return new ResponseEntity<String>("Successfully deleted Client(s)", HttpStatus.OK);
		} catch (AHCustomException e) {
			throw new WebServerException(e.getErrorMessage(), e);
		}
	}
	
}
