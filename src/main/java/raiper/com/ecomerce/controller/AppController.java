package raiper.com.ecomerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/api/index")
    public String index() {
        return "Hello World";
    }
}
