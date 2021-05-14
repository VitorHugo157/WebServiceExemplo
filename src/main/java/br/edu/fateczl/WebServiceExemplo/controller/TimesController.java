package br.edu.fateczl.WebServiceExemplo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.edu.fateczl.WebServiceExemplo.model.entity.Times;
import br.edu.fateczl.WebServiceExemplo.model.entity.dto.TimesDTO;
import br.edu.fateczl.WebServiceExemplo.repository.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimesController {

	@Autowired
	private TimesRepository tRep;
	
	@GetMapping("/times")
	public ResponseEntity<List<TimesDTO>> getAllTimes(){
		
		List<Times> listaTimes = tRep.findAll();
		List<TimesDTO> listaTimesDTO = converteListaTimes(listaTimes);
		return ResponseEntity.ok().body(listaTimesDTO);
	}
	
	@GetMapping("/times/{id}")
	public ResponseEntity<TimesDTO> getTime(@PathVariable(value = "id") Integer id) {

		Times time = tRep.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "invalido"));
		TimesDTO dto = converteTime(time);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping("/times")
	public ResponseEntity<String> crudTimes(@Valid @RequestBody Times t){
		
		String saida = tRep.spCrudTimes(t.getCod(), t.getId(), t.getNome(), t.getCidade());
		return ResponseEntity.ok().body(saida);
	}
	
	@SuppressWarnings("unused")
	private TimesDTO converteTime(Times t) {
		TimesDTO tDto = new TimesDTO();
		tDto.setId(t.getId());
		tDto.setNome(t.getNome());
		tDto.setCidade(t.getCidade());
		
		return tDto;
 	}
	
	private List<TimesDTO> converteListaTimes(List<Times> listaTimes){
		List<TimesDTO> lista = new ArrayList<>();
		for (Times t : listaTimes) {
			TimesDTO tDto = new TimesDTO();
			tDto.setId(t.getId());
			tDto.setNome(t.getNome());
			tDto.setCidade(t.getCidade());
			lista.add(tDto);
		}
		return lista;
	}
}
