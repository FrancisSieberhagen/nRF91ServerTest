package com.example.nRF91ServerTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class NRf91ServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NRf91ServerTestApplication.class, args);
	}

}

@RestController
class Action {

    boolean toggle = true;

    @RequestMapping("/")
    Map<String, Object> index() {

        Map<String, Object> rtn = new LinkedHashMap<>();

        rtn.put("ActionName", "BSDTest");
        rtn.put("LED1", toggle);
        rtn.put("LED2", !toggle);
        toggle = !toggle;
        return rtn;
    }
}
