package br.com.exemplo.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.exemplo.entity.AbstractEntity;
import br.com.exemplo.sevice.AbstractService;

public abstract class AbstractController<T extends AbstractEntity<ID>, ID extends Serializable>{

	protected abstract AbstractService<T, ID> getService();

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<T>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(getService().listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody T entidade) {
		entidade = getService().salvar(entidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidade.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") ID id) {
		T entidade = getService().buscar(id);

		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(entidade);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {
		getService().deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody T entidade, @PathVariable("id") ID id) {
		entidade.setId(id);
		getService().atualizar(entidade);

		return ResponseEntity.noContent().build();
	}
}
