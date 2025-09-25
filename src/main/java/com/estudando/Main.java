package com.estudando;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Quando vc insere um obj na base de dados vc pode tirar a instanciação dele do seu código pq ele jhá está inserido no banco
        //Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        //Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        //Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //em.persist(p1);
        //em.persist(p2);
        //em.persist(p3);
        //em.getTransaction().commit();

        System.out.println("Pronto");


        //BUSCAR DADO NO BANCO
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        //entidade monitorada na contexto de persistência
        //para agapar um obj persistido no banco ele tem q estar monitorada, que é um obj que acbou de ser inserido ou quando vc ainda não fechou o EntityManagr e deve recuperar com find o obj
        //transação,declara,busca e depois remove,commit



        em.close();
        emf.close();

    }}