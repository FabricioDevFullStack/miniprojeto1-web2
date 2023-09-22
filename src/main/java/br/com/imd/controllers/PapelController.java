package br.com.imd.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;

@RestController
public class PapelController {

	@RequestMapping("/papeis")
	public List<Papel> getPapeis() {
		return PapelRepository.getPapeis();
	}
	
	@PostMapping("/papeis")
	public Papel addPapel(@RequestBody Papel papel) {
		return PapelRepository.addPapel(papel);
	}

	@DeleteMapping("/papeis/{id}")
	public void deletePapelByUsuarioId(@PathVariable("id") int id) {
		PapelRepository.deletePapel(id);
	}
}
