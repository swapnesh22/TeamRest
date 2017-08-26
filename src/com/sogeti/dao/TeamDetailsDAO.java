package com.sogeti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sogeti.entities.TeamDetails;
import com.sogeti.utils.HibernateUtils;

public class TeamDetailsDAO {
	
	SessionFactory sessionFactory;
	Session session;
	
	public TeamDetailsDAO() {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public TeamDetails getTeamDetails(int employeeId) {
		
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		TeamDetails team = null;
		try {
			team = dao.getObjectById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return team;
	}
	
	public List<TeamDetails> getAll() {
		
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		List<TeamDetails> teamList = null;
		try {
			teamList = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return teamList;
	}
	
	public void addTeamDetails(TeamDetails team) {
		
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		try {
			dao.save(team);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public void deleteTeamMember(TeamDetails team) {
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		try {
			dao.delete(team.getEmployee_id());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public TeamDetails saveUpdate(TeamDetails team) {
		System.out.println("Inside DAO Update");
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		try {
			team = dao.merge(team);
			//dao.saveOrUpdate(team);
			System.out.println("Inside try "+team.getEmployee_name());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
			
			session.close();
		}
		return team;
	}
}
