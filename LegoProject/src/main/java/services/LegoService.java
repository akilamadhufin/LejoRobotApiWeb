package services;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.*;


@Path("/legoservice")
public class LegoService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lego");	
	
	
	@Path("/setrun")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Runlego setValues(Runlego rl) {
		System.out.println(rl);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(rl);
	    em.getTransaction().commit();		
		return rl;
	}
	

	
//	@Path("/gettime")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Runlego getLatestRun() {
//		  EntityManager em=emf.createEntityManager();
//		    em.getTransaction().begin();
//		    TypedQuery<Runlego> query = em.createQuery("SELECT l.run FROM Runlego l ORDER BY l.time DESC", Runlego.class);
//			query.setMaxResults(1);
//			Runlego latestRunlego=query.getSingleResult();
//			em.close();
//		        return latestRunlego;
//	}
	
	@Path("/setobstaclevalues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Obstacale setObstacleValues(Obstacale ob) {
		System.out.println(ob);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(ob);
	    em.getTransaction().commit();		
		return ob;
	}
	
	@Path("/setfollow")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LineFollow setFollowValues(LineFollow ob) {
		System.out.println(ob);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(ob);
	    em.getTransaction().commit();		
		return ob;
	}
		 
	 @Path("/getobstacle")
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public Response getObstacle() {
	     EntityManager em = emf.createEntityManager();
	     try {
	         em.getTransaction().begin();

	         TypedQuery<Obstacale> query = em.createQuery(
	             "SELECT o FROM Obstacale o ORDER BY o.id DESC", 
	             Obstacale.class);
	         query.setMaxResults(1);

	         Obstacale obstacle = query.getSingleResult();
	         em.getTransaction().commit();
	         
	         // Construct the plain text response using StringBuilder
	         StringBuilder responseBuilder = new StringBuilder();
	         responseBuilder.append("#").append(obstacle.getId()).append("#")
	             .append(obstacle.getObstacleDistance()).append("#");

	         String response = responseBuilder.toString();

	         return Response.ok(response).build();
	     } catch (Exception e) {
	         if (em.getTransaction().isActive()) {
	             em.getTransaction().rollback();
	         }
	         return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	             .entity("Error occurred while retrieving obstacle data: " + e.getMessage())
	             .build();
	     } finally {
	         em.close();
	     }
	 }
 
	@Path("/getfollow/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getfollowValues() {
	    EntityManager em = emf.createEntityManager();
	    try {
	        em.getTransaction().begin();

	        TypedQuery<LineFollow> query = em.createQuery(
	        		"SELECT f FROM LineFollow f ORDER BY f.Id DESC", 
	        	    LineFollow.class);
	        	query.setMaxResults(1);

	        List<LineFollow> list = query.getResultList();
	        em.getTransaction().commit();
	        
	        // Construct the plain text response
	        StringBuilder responseBuilder = new StringBuilder();
	        for (LineFollow lineFollow : list) {
	            responseBuilder.append("#").append(lineFollow.getId()).append("#")                           
	            .append(lineFollow.getLeftMotorSpeed_1()).append("#")
                .append(lineFollow.getRightMotorSpeed_1()).append("#")
                .append(lineFollow.getLeftMotorSpeed_2()).append("#")
                .append(lineFollow.getRightMotorSpeed_2()).append("#")
                .append(lineFollow.getTargetIntensity()).append("#\n");
	        }
	        
	        return Response.ok(responseBuilder.toString()).build();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Error occurred while retrieving data: " + e.getMessage())
	            .build();
	    } finally {
	        em.close();
	    }
	}

	
		//added these two by Yashodha
		//Save Robot values 
		@Path("/setrobotvalues")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public RobotData setRobotValues(RobotData ob) {
			System.out.println(ob);
		    EntityManager em=emf.createEntityManager();
		    em.getTransaction().begin();
		    em.merge(ob);
		    em.getTransaction().commit();		
			return ob;
		}
		
		//get values insert by robot 
		@Path("/getrobotvalues")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getRobotValues() 
		{
		    EntityManager em=emf.createEntityManager();
		    try 
		    {
		        em.getTransaction().begin();
		        //need to change the query after data feed is done for the robotdata table
		        TypedQuery<RobotData> query = em.createQuery(
		            "SELECT r FROM RobotData r WHERE r.id IN (SELECT MAX(r1.id) FROM RobotData r1 GROUP BY r1.currentIntensity) ORDER BY r.id DESC",
		        		RobotData.class);
		        

		        List<RobotData> list = query.getResultList();
		        em.getTransaction().commit();
		        
		        // Construct the plain text response
		        StringBuilder responseBuilder = new StringBuilder();
		        for (RobotData robotData : list) 
		        {
		            responseBuilder.append("#").append(robotData.getId()).append("#")
		                           .append(robotData.getCurrentIntensity()).append("#")
		                           .append(robotData.getCurrentSpeedLeftMotor()).append("#")
		                           .append(robotData.getCurrentSpeedRightMotor()).append("#")
		                           .append(robotData.getCurrentSpeedLeftMotor1()).append("#")
		                           .append(robotData.getCurrentSpeedRightMotor2()).append("#\n");
		            
		        }
		        
		        return Response.ok(responseBuilder.toString()).build();		        
		       
		    } 
		    catch (Exception e) 
		    {
		        if (em.getTransaction().isActive()) 
		        {
		            em.getTransaction().rollback();
		        }
		        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
		            .entity("Error occurred while retrieving data: " + e.getMessage())
		            .build();
		    } 
		    
		    finally 
		    {
		        em.close();
		    }
		}
			
//Getrun
	@Path("/getrun")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getRunValues() {
	    EntityManager em = emf.createEntityManager();
	    try {
	        em.getTransaction().begin();

	        TypedQuery<Runlego> query = em.createQuery(
	            "SELECT l FROM Runlego l ORDER BY l.Id DESC", 
	            Runlego.class);
	        query.setMaxResults(1);

	        List<Runlego> list = query.getResultList();
	        em.getTransaction().commit();
	        
	        // Construct the plain text response
	        StringBuilder responseBuilder = new StringBuilder();
	        for (Runlego runlego : list) {
	            responseBuilder.append("#").append(runlego.getId()).append("#")
	                .append(runlego.getRun()).append("#");
	        }
	        
	        return Response.ok(responseBuilder.toString()).build();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Error occurred while retrieving data: " + e.getMessage())
	            .build();
	    } finally {
	        em.close();
	    }
	}



}
