package com.Anilber.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.Anilber.model.Consultass;
import com.Anilber.model.Usuarioparcial;

public class ConsultaDao {
	
	
public List<Consultass> consultaLista(){
		
		List<Consultass>listacon = new ArrayList();
		
		EntityManager em;
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("AnilberParcial2");
		em=emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			listacon= em.createQuery("FROM Consultass").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return listacon;
	}


public List<Usuarioparcial> consultaUsu(Usuarioparcial up){
	
	List<Usuarioparcial>listausuario = new ArrayList<>();
	
	EntityManager em;
	EntityManagerFactory emf;
	emf= Persistence.createEntityManagerFactory("AnilberParcial2");
	em=emf.createEntityManager();
	
	
	try {
		em.getTransaction().begin();
		listausuario= em.createQuery("from Usuarioparcial as a where a.nombre = '"+up.getNombre()+"' and a.contrasenia='"+ up.getContrasenia()+"'").getResultList();
		em.getTransaction().commit();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	return listausuario;
}



public void actualizarDatos(Consultass con) {
	
	EntityManager em;
	EntityManagerFactory emf;
	emf= Persistence.createEntityManagerFactory("AnilberParcial2");
	em=emf.createEntityManager();
	con.getId();
	con.getNombre();
	con.getApellido();
	em.getTransaction().begin();
	em.merge(con);
	em.flush();
	em.getTransaction().commit();
}


public void eliminarDatos(Consultass con) {
	EntityManager em;
	EntityManagerFactory emf;
	emf= Persistence.createEntityManagerFactory("AnilberParcial2");
	em=emf.createEntityManager();
	con=em.getReference(Consultass.class, con.getId());
	em.getTransaction().begin();
	em.remove(con);
	em.flush();
	em.getTransaction().commit();
	
}











}
