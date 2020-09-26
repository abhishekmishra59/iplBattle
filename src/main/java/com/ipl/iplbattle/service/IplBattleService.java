package com.ipl.iplbattle.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ipl.iplbattle.exception.IPLException;

@Component
public class IplBattleService {

	public String getDetails(String name) {
		String result = "";
		if (name.equals("1")) {
			throw new IPLException(111, null, "simple error of IPLException type", HttpStatus.NOT_FOUND);
		} else if (name.equals("2")) {
			throw new IPLException(111, null, "simple error of IPLException type", HttpStatus.BAD_REQUEST);
		} else if (name.equals("3")) {
			throw new NullPointerException("Error raised as Nullpointer");
		} else {
			result = "test "+name;
		}
		return result;
	}

}
