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
import it.dstech.model.Ricetta;
import it.dstech.repositories.RicettaRepository;

@Controller
public class RicettaCotroller {

	@Autowired
	private RicettaRepository ricettaRepository;
	
//	Registrazione ricetta e salvataggio nel repository.
	
	@GetMapping("registraRicetta")
	public String registraRicettaForm(Ricetta ricetta) {
		return "add-ricetta";
	}
	
    @PostMapping("/addricetta")
    public String addRicetta(Ricetta ricetta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ricetta";
        }
        double costo = 0;
        for (Ingrediente ingrediente : ricetta.getListaIngredienti()) {
			costo += ingrediente.getCosto();
		}
        ricetta.setCostoRicetta((costo*110)/100);
        ricettaRepository.save(ricetta);
        model.addAttribute("ricetta", ricettaRepository.findAll());
        return "index";
    }
    
//  Modifica l'ricetta
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Ricetta ricetta = ricettaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ricetta Id:" + id));
        model.addAttribute("ricetta", ricetta);
        return "update-ricetta";
    }
    
    @PostMapping("/update/{id}")
    public String updateDolce(@PathVariable("id") long id,@RequestBody  Ricetta ricetta, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	ricetta.setId(id);
            return "update-ricetta";
        }
        
        ricettaRepository.save(ricetta);
        model.addAttribute("ricetta", ricettaRepository.findAll());
        return "index";
    }
    
//  Elimina l'ricetta
    
    @GetMapping("/delete/{id}")
    public String deleteDolce(@PathVariable("id") long id, Model model) {
    	Ricetta ricetta = ricettaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid dolce Id:" + id));
        ricettaRepository.delete(ricetta);
        model.addAttribute("ricetta", ricettaRepository.findAll());
        return "index";
    }
	
}
