package br.com.exemplo.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.exemplo.entity.Erro;
import br.com.exemplo.sevice.exceptions.RegistroExistenteException;
import br.com.exemplo.sevice.exceptions.RegistroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ResponseEntity<Erro> handleLivroNaoEncontradoException
							(RegistroNaoEncontradoException e, HttpServletRequest request) {
		
		Erro erro = new Erro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(RegistroExistenteException.class)
	public ResponseEntity<Erro> handleAutorExistenteException
							(RegistroExistenteException e, HttpServletRequest request) {
		
		Erro erro = new Erro();
		erro.setStatus(409l);
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
		
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Erro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request) {
		
		Erro erro = new Erro();
		erro.setStatus(400l);
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}