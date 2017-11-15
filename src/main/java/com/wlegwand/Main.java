package com.wlegwand;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Main {

    @RequestMapping("/")
    String home() {
        return "Hey fuck face!";
    }
	
	@RequestMapping("/addUser")
    String addUser() {
        return "User added";
    }


    /**
     * Tutaj jest opis metody
     *
     *
     * @param name to je zmienna name
     * @return zwraca stringa
     */
	@RequestMapping("/getName/{name}")
	String getName(@PathVariable String name) {
		return "Hello " + name;
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }



}