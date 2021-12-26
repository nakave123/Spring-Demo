/**
 * 
 */
package edu.neu.spring.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pratiknakave
 *
 */
@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String syaHello() {
		return "Hello World!";
	}
}
