package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.dstech.model.Ingrediente;
import it.dstech.repositories.IngredienteRepository;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
//	Registrazione Ingrediente e salvataggio nel repository.
	
	@GetMapping("registraIngrediente")
	public String registraIngredienteForm(Ingrediente ingrediente) {
		return "add-ingrediente";
	}
	
    @PostMapping("/addingrediente")
    public String addIngrediente(Ingrediente ingrediente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ingrediente";
        }
        ingredienteRepository.save(ingrediente);
        model.addAttribute("ingrediente", ingredienteRepository.findAll());
        return "index";
    }
    
//  Modifica l'ingrediente
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ingrediente Id:" + id));
        model.addAttribute("ingrediente", ingrediente);
        return "update-ingrediente";
    }
    
    @PostMapping("/update/{id}")
    public String updateIngrediente(@PathVariable("id") long id,@RequestBody  Ingrediente ingrediente, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	ingrediente.setId(id);
            return "update-ingrediente";
        }
        
        ingredienteRepository.save(ingrediente);
        model.addAttribute("ingrediente", ingredienteRepository.findAll());
        return "index";
    }
    
//  Elimina l'ingrediente
    
    @GetMapping("/delete/{id}")
    public String deleteIngrediente(@PathVariable("id") long id, Model model) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ingrediente Id:" + id));
        ingredienteRepository.delete(ingrediente);
        model.addAttribute("ingrediente", ingredienteRepository.findAll());
        return "index";
    }

}
