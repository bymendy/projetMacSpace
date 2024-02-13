import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public String createClient(@RequestBody Client client) {
        clientService.createClient(client);
        return "Client créé avec succès.";
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        clientService.updateClient(id, client);
        return "Client mis à jour avec succès.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return "Client supprimé avec succès.";
    }
}