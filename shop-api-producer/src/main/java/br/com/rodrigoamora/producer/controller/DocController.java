package br.com.rodrigoamora.producer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DocController {

	@GetMapping("/")
    public RedirectView redirectToSwagger() {
        return new RedirectView("/swagger-ui/index.html");
    }
    
    
    @GetMapping("/redoc")
    public RedirectView redirectRedoc() {
        return new RedirectView("/redoc.html");
    }
    
}
