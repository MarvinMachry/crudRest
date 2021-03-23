/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Veiculos;
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
public class VeiculoDAO implements Serializable{
    
    @PersistenceContext(unitName = "SW-CRUDREST-PRES-PU")
    private EntityManager em;
    
    private List<Veiculos> lista;

    public VeiculoDAO() {
    }

    public Veiculos persist(Veiculos objeto) throws Exception{
        objeto.setId(null);
        em.persist(objeto);
        return objeto;
    }
    
    public Veiculos merge(Veiculos objeto) throws Exception{
        em.merge(objeto);
        return objeto;
    }
    
    public void remove(Object id) throws Exception{
        Veiculos obj = em.find(Veiculos.class, id);
        em.remove(obj);
    }
    
    public Veiculos findById(Object id) throws Exception{
        return (Veiculos) em.find(Veiculos.class, id);
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
    public List<Veiculos> getLista() throws Exception{
        return em.createQuery("from Veiculos order by id").getResultList();
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Veiculos> lista) {
        this.lista = lista;
    }
    
}
