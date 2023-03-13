package com.code.springnoxml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.code.springnoxml", "com.code.springdemo.utils"})
public class SportsConfig {

    // @Bean
	// public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
	// 									 @Value("${printed.logger.level}") String printedLoggerLevel) {
 
	// 	MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
 
	// 	return myLoggerConfig;
	// }
 
	// // define bean for our sad fortune service
	// @Bean
	// public FortuneService sadFortuneService() {
	// 	return new SadFortuneService();
	// }
 
	// // define bean for our football coach AND inject dependency
	// @Bean
	// public Coach footballCoach() {
	// 	FootballCoach myFootballCoach = new FootballCoach(sadFortuneService());
 
	// 	return myFootballCoach;
	// }
 
}
