package mvntest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

	private static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

	public static void main(String[] args) {
		logger.trace("trace level: {}, {} ", 1, 2);
		logger.debug("debug level: {}, {} ", 1, 2);
		logger.info("info level: {}, {} ", 1, 2);
		logger.warn("warn level: {}, {} ", 1, 2);
		logger.error("error level: {}, {} ", 1, 2);
	}

}
