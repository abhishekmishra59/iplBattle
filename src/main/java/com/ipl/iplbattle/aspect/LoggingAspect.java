package com.ipl.iplbattle.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.ipl.iplbattle.exception.IPLException;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOG = LoggerFactory.getLogger("analytics");
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("controllerPackage()")
	public Object logAroundOfController(final ProceedingJoinPoint pjp) throws Throwable {

		final StopWatch stopWatch = new StopWatch();

		final Signature signature = pjp.getSignature();
		final String targetMethodName = signature.getName();
		final String targetMethodClass = pjp.getTarget().toString();
		final String corelationid = CoRelation.getCorelationid();

		final StringBuilder argsString = new StringBuilder();
		this.getArguments(pjp.getArgs(), argsString);

		final StringBuilder requestMessage = new StringBuilder();
		requestMessage.append("CORELATIONID").append(corelationid).append("; ClassName:").append(targetMethodClass)
				.append("; method: ").append(targetMethodName).append("Method started; Input:").append(argsString);

		final String beforeMessage = new String(requestMessage);

		LOGGER.info(beforeMessage);
		try {
			stopWatch.start();
			Object result = pjp.proceed();
			final StringBuilder successMessage = new StringBuilder();
			successMessage.append("CORELATIONID").append(corelationid).append("; ClassName:").append(targetMethodClass)
					.append("; method: ").append(targetMethodName).append("Method completed; Result:").append(result);
			String sMsg = new String(successMessage);
			LOGGER.info(sMsg);
			stopWatch.stop();
			LOG.info("Status :SUCCESS; Execution time of " + targetMethodClass + "." + targetMethodName + " :: "
					+ stopWatch.getTotalTimeMillis() + " ms");

			return result;
		} catch (Exception e) {
			final StringBuilder errorMessage = new StringBuilder();
			IPLException ex = (IPLException) e;
			errorMessage.append("CORELATIONID").append(corelationid).append("; ClassName:").append(targetMethodClass)
					.append("; method: ").append(targetMethodName).append(". Exception occured: ")
					.append(ex.getErrorMessage());
			String eMsg = new String(errorMessage);
			
			if ( ex.getStatus().equals(HttpStatus.NOT_FOUND)) {
				LOGGER.info(eMsg);
			} else {
				LOGGER.error(eMsg);
			}
			ex.setStopWatch(stopWatch);
			ex.setTargetClass(targetMethodClass);
			ex.setTargetMethod(targetMethodName);
			throw ex;
		}

	}

	@Pointcut("execution(* com.ipl.iplbattle" + ".controller..*(..))")
	public void controllerPackage() {
		/* Empty method only for defining pointcut expression */
	}

	private void getArguments(final Object[] args, final StringBuilder argsString) {
		if (args.length > 0) {
			for (final Object o : args) {
				argsString.append(o).append("; ");
			}
		}
	}

}
