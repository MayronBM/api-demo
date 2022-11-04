package ni.com.ucem.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HolaCarnal {

    @GetMapping("/funciona")
    public String queNota(){
        return "Esperemos que funcione";
    }
}
