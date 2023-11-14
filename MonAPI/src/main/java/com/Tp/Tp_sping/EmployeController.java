package com.Tp.Tp_sping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employes")
public class EmployeController {
	
	@Autowired
	private EmployeRepository EmployeRepository;
	
	@PostMapping("/employe")
	employe newEmploiye(@RequestBody employe newEmploiye){
		
		return EmployeRepository.save(newEmploiye);
		
	}
	
	@GetMapping("/employe")
	List<employe> getAllEmployes(){
		return EmployeRepository.findAll();
	}

    @PutMapping("/employe/{id}")
    public ResponseEntity<employe> updateEmployee(@PathVariable long id,@RequestBody employe employe) {
        employe updateEmploye = EmployeRepository.findById(id).orElseThrow();
        

   
        updateEmploye.setPrenom(employe.getPrenom());
        updateEmploye.setNom(employe.getNom());
        updateEmploye.setAdresse(employe.getAdresse());
        updateEmploye.setSalaire(employe.getSalaire());

        EmployeRepository.save(updateEmploye);

        return ResponseEntity.ok(updateEmploye);
    }

	
	@DeleteMapping("/employe/{id}")
	public void deleteEmploiye(@PathVariable Long id) {
	    EmployeRepository.deleteById(id);
	}


	
}