package co.za.sbg.iot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LedController {

    boolean toggle = true;

    @RequestMapping("/")
    public Map<String, Object> index() {
        Map<String, Object> rtn = new LinkedHashMap<>();
        rtn.put("ActionName", "BSDTest");
        rtn.put("LED1", toggle);
        rtn.put("LED2", !toggle);
        toggle = !toggle;
        return rtn;
    }
}
