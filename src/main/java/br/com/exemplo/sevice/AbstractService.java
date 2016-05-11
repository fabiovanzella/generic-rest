package br.com.exemplo.sevice;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.entity.AbstractEntity;
import br.com.exemplo.sevice.exceptions.RegistroExistenteException;
import br.com.exemplo.sevice.exceptions.RegistroNaoEncontradoException;

public abstract class AbstractService<T extends AbstractEntity<ID>, ID extends Serializable> {

	protected final String FALHA_DELETAR = "Falha ao deletar";
	protected final String FALHA_SALVAR = "Falha ao salvar";
	protected final String FALHA_CONSULTAR = "Falha ao consultar";
	protected final String FALHA_ATUALIZAR = "Falha ao atualizar";
	
	protected abstract JpaRepository<T, ID> getRepository();
	
	public List<T> listar() {
		return getRepository().findAll();
	}	
	
	public T salvar(T entidade) {
		if(entidade.getId() != null) {
			T consulta = getRepository().findOne(entidade.getId());
			
			if(consulta != null) {
				throw new RegistroExistenteException(String.format("%s, O Resgitro já existe.", FALHA_SALVAR));
			}
		}
		return getRepository().save(entidade);
	}
	
	public T buscar(ID id) {
		T entidade = getRepository().findOne(id);
		
		if(entidade == null) {
			throw new RegistroNaoEncontradoException(String.format("%s, O Registro não pôde ser encontrado.", FALHA_CONSULTAR));
		}
		return entidade;
	}
	
	public void deletar(ID id) {
		try {
			getRepository().delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RegistroNaoEncontradoException(String.format("%s, O Registro não pôde ser encontrado.", FALHA_DELETAR));
		}
	}
	
	public void atualizar(T entidade) {
		T consulta = getRepository().findOne(entidade.getId());
		
		if(consulta == null) {
			throw new RegistroNaoEncontradoException(String.format("%s, O registro não pôde ser encontrado.", FALHA_ATUALIZAR));
		}
		getRepository().save(entidade);
	}
}
