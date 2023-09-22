package br.com.imd.controllers;

import java.util.List;

import br.com.imd.repositories.PapelRepository;
import org.springframework.web.bind.annotation.*;

import br.com.imd.domain.Usuario;
import br.com.imd.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@RequestMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return UsuarioRepository.getUsuarios();
	}

	@RequestMapping("/usuarios/{id}")
	public Usuario getUsuarioById(@PathVariable("id") int id) {
		return UsuarioRepository.getUsuario(id);
	}

	@PostMapping("/usuarios")
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return UsuarioRepository.addUsuario(usuario);
	}

	@PutMapping("/usuarios")
	public Usuario editUsuario(@RequestBody Usuario usuario) {
		return UsuarioRepository.editUsuario(usuario);
	}

	@DeleteMapping("/usuarios/{id}")
	public void deleteUsuario(@PathVariable("id") int id) {
		UsuarioRepository.deleteUsuario(id);
	}

}
