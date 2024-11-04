package com.infosupport.dao;

import com.infosupport.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamDao {

    private static Logger log = LoggerFactory.getLogger(TeamDao.class);
    private EntityManagerFactory emf;

    public TeamDao(EntityManagerFactory emf /*, Type eenObject*/) {
        this.emf = emf;
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
