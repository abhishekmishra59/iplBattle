package com.ipl.iplbattle.advice;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.ipl.iplbattle.exception.IPLException;

@RestControllerAdvice
public class IPLWebRestControllerAdvice {
	private static final Logger LOG = LoggerFactory.getLogger("analytics");

	@ExceptionHandler(IPLException.class)
	public ResponseEntity<ResponseMsg> handleDEPException(final IPLException exception, final WebRequest request) {
		final ResponseMsg msg = new ResponseMsg(exception.getErrorCode(), exception.getErrorMessage());

		final HttpHeaders respErrorHeaders = new HttpHeaders();
		final Iterator<String> headerIterator = request.getHeaderNames();
		while (headerIterator.hasNext()) {
			final String headerName = headerIterator.next();
			if (!headerName.equals("content-length")) {
				respErrorHeaders.add(headerName, request.getHeader(headerName));
			}
		}
		respErrorHeaders.setDate(System.currentTimeMillis());
		StopWatch stopWatch = exception.getStopWatch();
		stopWatch.stop();
		LOG.info("Status :Error; Execution time of " + exception.getTargetClass() + "." + exception.getTargetMethod()
				+ " :: " + stopWatch.getTotalTimeMillis() + " ms");

		return new ResponseEntity<>(msg, respErrorHeaders, exception.getStatus());
	}

}
