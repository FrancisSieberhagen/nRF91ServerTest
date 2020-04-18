package com.example.nRF91ServerTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class NRf91ServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NRf91ServerTestApplication.class, args);
	}

}

@RestController
class Action {

    @RequestMapping("/")
    String index() {
        return "{\"ActionName\":\"BSD Test\",\"LED1\":true,\"LED2\":true}";
    }
}
