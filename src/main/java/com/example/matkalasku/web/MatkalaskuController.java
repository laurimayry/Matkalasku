package com.example.matkalasku.web;

import java.util.List;
import java.util.Optional;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.matkalasku.domain.Lasku;
import com.example.matkalasku.domain.LaskuRepository;




@Controller
public class MatkalaskuController {

	@Autowired
	private LaskuRepository repository; 
	
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	//LISTAA KAIKKI LASKUT
	
    @RequestMapping(value= {"/", "/laskulistaus"})
    public String laskuList(Model model) {	
        model.addAttribute("laskut", repository.findAll());
        return "laskulistaus";
    }
    
    //LISÄÄ LASKUN
    
	@RequestMapping(value = "/add")
	public String addLasku(Model model) {
		model.addAttribute("lasku", new Lasku());
		return "addlasku";
	}
	
	
	//TALLENTAA LASKUN
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Lasku lasku, Model model) {

		double korvaus = lasku.getKilometrit() * 0.53;
        lasku.setKorvaus(korvaus); 
		
		repository.save(lasku);
		return "redirect:laskulistaus";
	}
	
	// POISTAA LASKUN

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@Transactional
	public String delete(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../laskulistaus";
	}
	
	// Edit student
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLasku(@PathVariable("id") Long id, Model model) {
    	
		Optional<Lasku> optionalLasku = repository.findById(id);
			
		if (optionalLasku.isPresent()) {
			Lasku lasku = optionalLasku.get();
			model.addAttribute("lasku", lasku);		


			return "editlasku";
		} else {

			return "redirect:/laskulistaus";
		}
	}
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute Lasku updatedLasku) {
		
		Lasku existingLasku = repository.findById(updatedLasku.getId()).orElse(null);

	    if (existingLasku != null) {

	    	existingLasku.setPvm(updatedLasku.getPvm());
	    	existingLasku.setLahtoOsoite(updatedLasku.getLahtoOsoite());
	    	existingLasku.setMaaranpaa(updatedLasku.getMaaranpaa());
	    	existingLasku.setKilometrit(updatedLasku.getKilometrit());
	    	existingLasku.setKorvaus(updatedLasku.getKilometrit() * 0.53);

	    	
	    	
	        repository.save(existingLasku);
	        return "redirect:/laskulistaus";
	       } 
	    	else {
	        return "redirect:/laskulistaus";
	    	}
    	}
    
	// RESTful service to get all books
    @RequestMapping(value="/laskut", method = RequestMethod.GET)
    public @ResponseBody List<Lasku> LaskuListRest() {	
        return (List<Lasku>) repository.findAll();
    }    

	// RESTful service to get books by id
    @RequestMapping(value="/laskut/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Lasku> findLaskuRest(@PathVariable("id") Long id) {	
    	return repository.findById(id);
    }   
}
    
    
    
    
    
    
	
	
	
	
