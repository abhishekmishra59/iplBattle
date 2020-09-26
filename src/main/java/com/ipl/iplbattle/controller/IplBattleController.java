package com.ipl.iplbattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.iplbattle.exception.IPLException;
import com.ipl.iplbattle.service.IplBattleService;

@RestController
public class IplBattleController implements IplBattleApi {

	@Autowired
	private IplBattleService iplBattleService;

	@Override
	public ResponseEntity<String> getDetails(String name) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<String>(iplBattleService.getDetails(name), HttpStatus.OK);
		} catch (IPLException e) {
			throw e;	
		} catch (Exception e) {
			throw new IPLException(12345, "Generic Error", e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
