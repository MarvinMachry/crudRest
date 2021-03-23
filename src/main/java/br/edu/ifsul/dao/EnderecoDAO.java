/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Endereco;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author imarv
 */
@Stateless
public class EnderecoDAO implements Serializable{
    
    @PersistenceContext(unitName = "SW-CRUDREST-PRES-PU")
    private EntityManager em;
    
    private List<Endereco> lista;

    public EnderecoDAO() {
    }

    public Endereco persist(Endereco objeto) throws Exception{
        objeto.setId(null);
        em.persist(objeto);
        return objeto;
    }
    
    public Endereco merge(Endereco objeto) throws Exception{
        em.merge(objeto);
        return objeto;
    }
    
    public void remove(Object id) throws Exception{
        Endereco obj = em.find(Endereco.class, id);
        em.remove(obj);
    }
    
    public Endereco findById(Object id) throws Exception{
        return (Endereco) em.find(Endereco.class, id);
    }
    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the lista
     */
    public List<Endereco> getLista() throws Exception{
        return em.createQuery("from Endereco order by id").getResultList();
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Endereco> lista) {
        this.lista = lista;
    }
    
}
