package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imd.domain.Papel;
import br.com.imd.domain.Usuario;

public class UsuarioRepository {

	public static List<Usuario> usuarios = new ArrayList<>();

	private static int generatorId = 1;

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static Usuario getUsuario(int id) {
		return usuarios.stream().filter(usuario -> usuario.getId() == id).collect(Collectors.toList()).get(0);
	}

	public static Usuario addUsuario(Usuario u) {
		u.setId(generatorId++);

		for(Papel p : u.getPapeis())
			PapelRepository.addPapel(p);
		usuarios.add(u);

		return u;
	}

	public static Usuario editUsuario(Usuario u) {
		for(Usuario usuario : usuarios) {
			if(usuario.getId() == u.getId()) {
				usuario.setNome(u.getNome());
				usuario.setPapeis(u.getPapeis());
			}
		}

		return u;
	}

	public static void deleteUsuario(int id) {
		usuarios = usuarios.stream().filter(usuario -> usuario.getId() != id).collect(Collectors.toList());
	}
}
