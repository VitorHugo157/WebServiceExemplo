package br.edu.fateczl.WebServiceExemplo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.edu.fateczl.WebServiceExemplo.model.entity.Jogador;
import br.edu.fateczl.WebServiceExemplo.model.entity.dto.JogadorDTO;
import br.edu.fateczl.WebServiceExemplo.model.entity.dto.TimesDTO;
import br.edu.fateczl.WebServiceExemplo.repository.JogadorRepository;
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
@RequestMapping("/api")
public class JogadorController {

	@Autowired
	private JogadorRepository JRep;
	
	@GetMapping("/jogador")
	public ResponseEntity<List<JogadorDTO>> getAllJogador(){
		
		List<Jogador> lista = JRep.findJogadoresDataConv();
		List<JogadorDTO> novaLista = converteListaJogador(lista);
		return ResponseEntity.ok().body(novaLista);
	}
	
	@GetMapping("/jogador/{id}")
	public ResponseEntity<JogadorDTO> getTime(@PathVariable(value = "id") Integer id) {

		Jogador j = JRep.findJogadorDataConv(id);
		JogadorDTO dto = converteJogador(j);
		return ResponseEntity.ok().body(dto);
	}

	private JogadorDTO converteJogador(Jogador j) {

		JogadorDTO dto = new JogadorDTO();
		dto.setCodigo(j.getCodigo());
		dto.setNomeJogador(j.getNomeJogador());
		dto.setSexo(j.getSexo());
		dto.setAltura(j.getAltura());
		dto.setDt_nasc(j.getDt_nasc());
		
		TimesDTO tDto = new TimesDTO();
		tDto.setId(j.getTimes().getId());
		tDto.setNome(j.getTimes().getNome());
		tDto.setCidade(j.getTimes().getCidade());
		
		dto.setTimes(tDto);
		return dto;
	}
	
	@PostMapping("/jogador")
	public ResponseEntity<String> insertJogador(@Valid @RequestBody Jogador j){
		
		JRep.save(j);
		return ResponseEntity.ok().body("Inserido com sucesso.");
	}
	
	@PutMapping("/jogador")
	public ResponseEntity<String> updateJogador(@Valid @RequestBody Jogador j){
		
		JRep.save(j);
		return ResponseEntity.ok().body("Atualizado com sucesso.");
	}
	
	@DeleteMapping("/jogador")
	public ResponseEntity<String> deletarJogador(@Valid @RequestBody Jogador j){
		
		JRep.delete(j);
		return ResponseEntity.ok().body("Excluido com sucesso.");
	}

	private List<JogadorDTO> converteListaJogador(List<Jogador> lista) {

		List<JogadorDTO> list = new ArrayList<JogadorDTO>();
		
		for (Jogador j : lista) {
			JogadorDTO dto = new JogadorDTO();
			dto.setCodigo(j.getCodigo());
			dto.setNomeJogador(j.getNomeJogador());
			dto.setSexo(j.getSexo());
			dto.setAltura(j.getAltura());
			dto.setDt_nasc(j.getDt_nasc());
			
			TimesDTO tDto = new TimesDTO();
			tDto.setId(j.getTimes().getId());
			tDto.setNome(j.getTimes().getNome());
			tDto.setCidade(j.getTimes().getCidade());
			
			dto.setTimes(tDto);
			list.add(dto);
		}
		return list;
	}
}
