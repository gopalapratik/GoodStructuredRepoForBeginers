package com.practice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2 {
	
	private static Logger log = LogManager.getLogger(Log4j2.class);

	public static void main(String[] args) {
		
		
		
		log.info("This is Information msg");
		log.warn("Warn msg");
		log.error("error msg");
		log.fatal("Fatal msg");
		
	}
	
}
