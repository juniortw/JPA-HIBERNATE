package br.com.junior.Aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.junior.Bean.Pessoa;

public class App {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Maria", "maria@email.com");
		Pessoa p2 = new Pessoa(null, "Joao", "Joao@email.com");
		Pessoa p3 = new Pessoa(null, "Junior", "Junior@email.com");
		
		//Criar uma Persistencia no Banco
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		//Mapeia as entidades
		EntityManager em = emf.createEntityManager();
		
		Adicionar(p1, em);
		Adicionar(p2, em);
		Adicionar(p3, em);
		
		Buscar(2, em);
		
		Remover(p1, 1, em);
		
		emf.close();
		em.close();
		
	}

	private static void Remover(Pessoa p, Integer id, EntityManager em) {
		//Removendo uma pessoa do banco
		em.find(Pessoa.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Removido!");
	}

	private static void Buscar(Integer id, EntityManager em) {
		//Buscando uma pessoa do banco
		Pessoa p = em.find(Pessoa.class, id);
		
		System.out.println(p);
		
	}

	private static void Adicionar(Pessoa p1, EntityManager em) {
		//Adicionando uma pessoa no bando
		em.getTransaction().begin(); 
		em.persist(p1);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
	}

}
