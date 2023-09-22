package br.com.imd.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imd.domain.Papel;

public class PapelRepository {

	private static List<Papel> papeis = new ArrayList<>();

	private static int generatorId = 1;

	public static List<Papel> getPapeis(){	
		return papeis;
	}
	
	public static Papel addPapel(Papel p) {
		p.setId(generatorId++);
		papeis.add(p);
		return p;
	}

	public static void deletePapel(int id) {
		papeis = papeis.stream().filter(papel -> papel.getId() != id).collect(Collectors.toList());
	}
	
}
