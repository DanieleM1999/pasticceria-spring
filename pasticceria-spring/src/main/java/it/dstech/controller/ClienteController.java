package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.dstech.model.Cliente;
import it.dstech.repositories.ClienteRepository;

@Controller
public class ClienteController {


	@Autowired
	private ClienteRepository clienteRepository;
	
//	Registrazione cliente e salvataggio nel repository.
	
	@GetMapping("registraCliente")
	public String registraClienteForm(Cliente cliente) {
		return "add-cliente";
	}
	
    @PostMapping("/addcliente")
    public String addCliente(Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-cliente";
        }
        clienteRepository.save(cliente);
        model.addAttribute("cliente", clienteRepository.findAll());
        return "index";
    }
    
//  Modifica l'cliente
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id));
        model.addAttribute("cliente", cliente);
        return "update-cliente";
    }
    
    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") long id,@RequestBody  Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	cliente.setId(id);
            return "update-cliente";
        }
        
        clienteRepository.save(cliente);
        model.addAttribute("cliente", clienteRepository.findAll());
        return "index";
    }
    
//  Elimina l'ingrediente
    
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") long id, Model model) {
    	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id));
        clienteRepository.delete(cliente);
        model.addAttribute("cliente", clienteRepository.findAll());
        return "index";
    }
	
}
