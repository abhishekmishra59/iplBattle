package com.ipl.iplbattle.controller;


import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "v1", description = "the v1 API")
public interface IplBattleApi {
	
	public static final String CONTROLLER_IPL = "ipl-controller";
	
	@ApiOperation(
		    value = "This API should test",
		    nickname = "getDetails", notes = "", response = ResponseStatus.class,
		    tags = { CONTROLLER_IPL, })
		    @ApiResponses(value = {
		    @ApiResponse(code = HttpStatus.SC_OK, message = "OK"),
		    @ApiResponse(code = HttpStatus.SC_BAD_REQUEST, message = "Bad Request "),
		    @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = "Unauthorized "),
		    @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = "Forbidden"),
		    @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = "Not Found"),
		    @ApiResponse(code = HttpStatus.SC_METHOD_NOT_ALLOWED,
		    message = "Method not allowed "),
		    @ApiResponse(code = HttpStatus.SC_NOT_ACCEPTABLE,
		    message = "Not Acceptable"),
		    @ApiResponse(code = HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE,
		    message = "Unsupported Media Type"),
		    @ApiResponse(code = HttpStatus.SC_INTERNAL_SERVER_ERROR,
		    message = "Internal server error"),
		    @ApiResponse(code = HttpStatus.SC_SERVICE_UNAVAILABLE,
		    message = "Service Unavailable"),
		    @ApiResponse(code = HttpStatus.SC_GATEWAY_TIMEOUT,
		    message = "Gateway Timeout") })
		    @RequestMapping(value = "/v1/getDetails",
		   /* produces = { MediaType.APPLICATION_JSON_VALUE },
		    consumes = { MediaType.APPLICATION_JSON_VALUE },*/
		    method = RequestMethod.GET)
	ResponseEntity<String> getDetails(@RequestParam String name);
}
