package com.sogeti.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sogeti.dao.TeamDetailsDAO;
import com.sogeti.entities.TeamDetails;

@Path("/TeamService")
public class TeamService {

		TeamDetailsDAO teamDao = new TeamDetailsDAO();
	   //private static final String SUCCESS_RESULT="<result>success</result>";
	   //private static final String FAILURE_RESULT="<result>failure</result>";


	   @GET
	   @Path("{employeeId}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public TeamDetails getTeamDetails(@PathParam ("employeeId") int employeeId) {
		   //http://localhost:8080/TeamRest/rest/TeamService/11338
	      TeamDetails team = teamDao.getTeamDetails(employeeId);
	      System.out.println("Get details by "+ employeeId +"--------------->>>>>>>>>>>>>> "+team.getEmployee_name());
	      return team;
	   }
	   
	   @GET
	   @Path("/All")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<TeamDetails> getAll() {
		   //http://localhost:8080/TeamRest/rest/TeamService/All
	      List<TeamDetails> teamList = teamDao.getAll();
	      System.out.println("Get size of List --------------->>>>>>>>>>>>>> "+teamList.size());
	      return teamList;
	   }
	   
	   @POST
	   @Path ("/addTeam")
	   @Consumes (MediaType.APPLICATION_JSON)
	   public Response addTeamDetails(TeamDetails team) {
		   //http://localhost:8080/TeamRest/rest/TeamService/addTeam
		   teamDao.addTeamDetails(team);
		   return Response.status(201).entity(team).build();
	   }
	   
	   @DELETE
	   @Path ("/deleteTeam")
	   @Consumes (MediaType.APPLICATION_JSON)
	   public Response deleteTeamDetails(TeamDetails team) {
		   //http://localhost:8080/TeamRest/rest/TeamService/deleteTeam
		   teamDao.deleteTeamMember(team);
		   return Response.status(201).entity(team).build();
	   }
	   
	   @PUT
	   @Path ("/updateTeam")
	   @Consumes (MediaType.APPLICATION_JSON)
	   public Response updateTeam(TeamDetails team) {
		 //http://localhost:8080/TeamRest/rest/TeamService/updateTeam
		   System.out.println("Calling Update");
		   teamDao.saveUpdate(team);
		   return Response.status(201).entity(team).build();
	   }
}
