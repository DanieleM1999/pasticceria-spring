package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.dstech.model.Dolce;
import it.dstech.model.Ordinazione;
import it.dstech.repositories.OrdinazioneRepository;

@Controller
public class OrdinazioneController {

	@Autowired
	private OrdinazioneRepository ordinazioneRepository;
	
//	Registrazione Ordinazione e salvataggio nel repository.
	
	@GetMapping("registraOrdinazione")
	public String registraOrdinazioneForm(Ordinazione ordinazione) {
		return "add-ordinazione";
	}
	
    @PostMapping("/addordinazione")
    public String addOrdinazione(Ordinazione ordinazione, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ordinazione";
        }
        double costo = 0;
        for (Dolce dolce : ordinazione.getListaDolci()) {
			costo += dolce.getCostoDolce();
		}
        ordinazione.setCostoOrdinazione(costo);
        ordinazioneRepository.save(ordinazione);
        model.addAttribute("ordinazione", ordinazioneRepository.findAll());
        return "index";
    }
    
//  Modifica l'ordinazione
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Ordinazione ordinazione = ordinazioneRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ordinazione Id:" + id));
        model.addAttribute("ordinazione", ordinazione);
        return "update-ordinazione";
    }
    
    @PostMapping("/update/{id}")
    public String updateOrdinazione(@PathVariable("id") long id,@RequestBody  Ordinazione ordinazione, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	ordinazione.setId(id);
            return "update-ordinazione";
        }
        
        ordinazioneRepository.save(ordinazione);
        model.addAttribute("ordinazione", ordinazioneRepository.findAll());
        return "index";
    }
    
//  Elimina l'ingrediente
    
    @GetMapping("/delete/{id}")
    public String deleteOrdinazione(@PathVariable("id") long id, Model model) {
    	Ordinazione ordinazione = ordinazioneRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ordinazione Id:" + id));
        ordinazioneRepository.delete(ordinazione);
        model.addAttribute("ordinazione", ordinazioneRepository.findAll());
        return "index";
    }
	
}
