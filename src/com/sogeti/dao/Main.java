package com.sogeti.dao;

import java.text.Annotation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sogeti.entities.TeamDetails;
import com.sogeti.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {
		/*TeamDetails team = new TeamDetails();
		team.setEmployee_id(12345);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.save(team);
		
		team = (TeamDetails) session.get(TeamDetails.class, 12345);
		
		System.out.println(team.getEmployee_name());
		
		team.setEmployee_name("SWK");
		
		session.update(team);
		
		//session.delete(team);
		
		session.getTransaction().commit();
		session.close();*/
		
		/*SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		DAO<TeamDetails> dao = new DAO<TeamDetails>(TeamDetails.class, session);
		TeamDetails team = dao.getObjectById(11338);
		System.out.println(team.getEmployee_name());
		session.close();*/
		
		//Add
		/*TeamDetailsDAO team = new TeamDetailsDAO();
		TeamDetails details = new TeamDetails();
		details.setEmployee_id(1234567);
		details.setEmployee_name("SWK7");
		details.setMonth("Feb7");
		details.setAmount(100);
		team.addTeamDetails(details);*/
		
		//Get on employeeId
		/*TeamDetailsDAO team1 = new TeamDetailsDAO();
		TeamDetails detail = team1.getTeamDetails(11338);
		System.out.println(detail.getEmployee_name());*/
		
		//Get all employees
		/*TeamDetailsDAO team2 = new TeamDetailsDAO();
		List<TeamDetails> teamList = null;
		teamList = team2.getAll();
		System.out.println("Size of List is "+teamList.size());*/
		
		//Delete
		/*TeamDetailsDAO team3 = new TeamDetailsDAO();
		TeamDetails det = new TeamDetails();
		det.setEmployee_id(1234567);
		team3.deleteTeamMember(det);*/
		
		//Merge
		TeamDetailsDAO team4 = new TeamDetailsDAO();
		TeamDetails det = new TeamDetails();
		det.setEmployee_id(1234);
		det.setEmployee_name("Neetesh");
		det.setAmount(100);
		det.setMonth("Jan");
		team4.saveUpdate(det);
		
	}

}
