package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/hello/multilingual", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> greetingInDifferentLanguages() {
        return Arrays.asList(
            "Hello (English)",
            "Bonjour (French)",
            "Hola (Spanish)",
            "Hallo (German)",
            "Ciao (Italian)"
        );
    }

}




