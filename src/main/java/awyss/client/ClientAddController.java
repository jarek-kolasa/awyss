package awyss.client;

import awyss.model.Client;
import awyss.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientAddController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clientadd")
    public String clientadd(Model model){
        model.addAttribute( "client",new Client() );
        return "client-add/client-add";
    }

    @PostMapping("/clientadd")
    public String saveClient(Client client){
        clientRepository.save( client );
        return "redirect:clientlist";
    }

}
