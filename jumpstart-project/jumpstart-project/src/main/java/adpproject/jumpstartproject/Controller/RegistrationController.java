package adpproject.jumpstartproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adpproject.jumpstartproject.Entity.Registration;
import adpproject.jumpstartproject.Service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationService service;
	
	@PostMapping("/register")
	public Registration newRegistration(@RequestBody Registration reg) {
		return service.register(reg);
	}
	
	@PostMapping("/registerMany")
	public List<Registration> newRegistration(@RequestBody List<Registration> reg) {
		return service.registerMultiple(reg);
	}
	
	@GetMapping("/findAllRegistration")
	public List<Registration> findAllRegistration(){
		return service.getAllRegistration();
	}
	
	
	@GetMapping("/findConditional")
	public List<Registration> getConditional(@RequestParam ("name") String name, @RequestParam ("org") String org){
		return service.getConditionalReg(name, org);
	}
	
	
	
	
	@GetMapping("/findRegistration/{id}")
	public Registration findRegistrationByID(@PathVariable int id) {
		return service.getRegistrationByID(id);
	}
	
	@GetMapping("/findRegistration/{name}")
	public Registration findRegistrationByName(@PathVariable String name) {
		return service.getRegistrationByName(name);
	}
	
	
	@PutMapping("/updateRegistration")
	public Registration updateRegistration(@RequestBody Registration reg) {
		return service.updateRegistration(reg);
	}
	
	@DeleteMapping("/deleteRegistration/{id}")
	public String deleteRegistration(@PathVariable int id) {
		return service.deleteRegistration(id);
	}
	
	

}
