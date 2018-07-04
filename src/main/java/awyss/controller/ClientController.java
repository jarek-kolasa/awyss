package awyss.controller;

import awyss.model.Client;
import awyss.repository.ClientRepository;
import awyss.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    private Long clientId;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(
            @RequestBody @Valid Client client,
            BindingResult bindingResult) {
        return clientService.create(client, bindingResult);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> search() {
        return clientRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long productId) {
        clientService.delete(clientId);
    }

}
