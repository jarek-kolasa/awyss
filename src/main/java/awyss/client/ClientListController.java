package awyss.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientListController {

    @GetMapping("/clientlist")
    public String clientlist(){
        return "client/clienlist";
    }
}
