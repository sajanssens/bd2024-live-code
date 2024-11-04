package com.infosupport.dao;

import com.infosupport.domain.Department;
import com.infosupport.domain.Person;
import com.infosupport.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentDao {

    private static Logger log = LoggerFactory.getLogger(DepartmentDao.class);
    private EntityManagerFactory emf;

    public DepartmentDao(EntityManagerFactory emf /*, Type eenObject*/) {
        this.emf = emf;
    }

    public void create(Department d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

    public Team findOneWithMembers(Team t){
        EntityManager em = emf.createEntityManager();
        Team team = em.createQuery("select DISTINCT(t) from Team t JOIN FETCH t.members where t.id = :teamId", Team.class)
                .setParameter("teamId", t.getId())
                .getSingleResult();
        em.close();
        return team;
    }

    public List<Team> findAllWithMembers(){
        EntityManager em = emf.createEntityManager();
        List<Team> resultList = em.createQuery("select DISTINCT(t) from Team t JOIN FETCH t.members", Team.class)
                .getResultList();
        em.close();
        return resultList;
    }
}
