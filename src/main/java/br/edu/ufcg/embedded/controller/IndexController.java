package br.edu.ufcg.embedded.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class IndexController {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getIndex(){
        return "Server On";
    }
}
