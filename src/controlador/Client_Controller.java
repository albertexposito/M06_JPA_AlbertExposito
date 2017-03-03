/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.*;

/**
 *
 * @author Jorge
 */
public class Client_Controller {

    public void Insertar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Client Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Client p = (Client) em.find(Client.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    public Client BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("ClientNom",Client.class);
        Query query = em.createNamedQuery(Client.CONSULTA,Client.class);
        query.setParameter("nombre", nom);
        Client p = (Client) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }

    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Client> lista = (List<Client>) em.createQuery("FROM Client").getResultList();
        Query q = em.createQuery("FROM Client");
        List<Client> lista = (List<Client>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    public void imprimirLista(List<Client> lista) {
        System.out.println("Numero d'empleats= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirClient(Client p) {
        System.out.println(p);
    }

}
