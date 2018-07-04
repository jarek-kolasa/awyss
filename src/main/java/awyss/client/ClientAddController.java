package awyss.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientAddController {

    @GetMapping("/clientadd")
    public String clientadd(){
        return "client/clientadd";
    }
}
