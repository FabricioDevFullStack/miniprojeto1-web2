package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.domain.Papel;
import br.com.imd.domain.Usuario;

public class UsuarioRepository {

	public static List<Usuario> usuarios = new ArrayList<>();

	private static int generatorId = 1;

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static Usuario addUsuario(Usuario u) {
		u.setId(generatorId++);

		for(Papel p : u.getPapeis())
			PapelRepository.addPapel(p);
		usuarios.add(u);

		return u;
	}
}
