package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("clienteDao")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll(){
		
		return em.createQuery("from Cliente").getResultList();
	}
	
	    @Override
	    @Transactional
	    public void save(Cliente cliente) {
	    	if(cliente.getId() != null && cliente.getId() > 0) {
	    		em.merge(cliente);
	    	}else {
	    		em.persist(cliente);
	    	}
	    }

}
