package br.edu.fateczl.WebServiceExemplo.controller;

import br.edu.fateczl.WebServiceExemplo.model.entity.JogadorTime;
import br.edu.fateczl.WebServiceExemplo.model.entity.dto.JogadorDTO;
import br.edu.fateczl.WebServiceExemplo.model.entity.dto.TimesDTO;
import br.edu.fateczl.WebServiceExemplo.repository.JogadorTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JogadorTimeController {
	
	@Autowired
	private JogadorTimeRepository jTRep;

	@GetMapping("jogador/idade/{id}")
	public ResponseEntity<JogadorDTO> getJogadorIdade(@PathVariable(value = "id") Integer id){
		
		JogadorTime jt = jTRep.udfJogadorIdade(id);
		JogadorDTO dto = converterJogadorTime(jt);
		return ResponseEntity.ok().body(dto);
	}

	private JogadorDTO converterJogadorTime(JogadorTime j) {

		JogadorDTO jDto = new JogadorDTO();
		jDto.setCodigo(j.getCodigo());
		jDto.setNomeJogador(j.getNomeJogador());
		jDto.setSexo(j.getSexo());
		jDto.setAltura(j.getAltura());
		jDto.setDt_nasc(j.getDt_nasc());
		jDto.setIdade(j.getIdade());
		
		TimesDTO tDto = new TimesDTO();
		tDto.setId(j.getId());
		tDto.setNome(j.getNome());
		tDto.setCidade(j.getCidade());
		
		jDto.setTimes(tDto);		
		
		return jDto;
	}
}
