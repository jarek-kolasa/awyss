package awyss.service;

import awyss.exception.BindingResultException;
import awyss.exception.NotFoundException;
import awyss.model.Client;
import awyss.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.Optional;
import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new NotFoundException(String.format("Client with id %s not found", id));
        }
        clientRepository.deleteById(id);
    }

    public Client getById( Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent()) {
            throw new NotFoundException(String.format("Client with id %s not found", id));
        }
        return client.get();
    }

    public List<Client> search( String clientName) {
        if (null == clientName) {
            clientName = "";
        }
        return clientRepository.findByClientNameContainingIgnoreCase(
                clientName);
    }


    public Client create(Client client,BindingResult bindingResult){
        validate(client,null,bindingResult);
        return clientRepository.save( client );
    }

    private void validate(Client client,String currentClientName,BindingResult bindingResult){
        if(!client.getClientName().equalsIgnoreCase( currentClientName )&& clientRepository.existsByClientNameIgnoreCase(client.getClientName())) {
            bindingResult.addError(
                    new FieldError("client", "clientName",
                            String.format("Client with name %s already exists", client.getClientName())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

    public Client saveClient( Client client ) {
        return clientRepository.save( client );
    }
}