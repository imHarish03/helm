package io.lab.imHarish03.helm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/helm")
public class Controller {

    @GetMapping
    public String getData(){
        return "Welcome to Helm";
    }

}
