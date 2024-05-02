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
	
	@Path("/getrun")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int getValues() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<Integer> q=em.createQuery("select l.run from Runlego l order by l.Id desc", Integer.class).setMaxResults(1);
		List<Integer> list=q.getResultList();
		em.getTransaction().commit();		
		return list.get(0);
	}
	
	@Path("/gettime")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Runlego getLatestRun() {
		  EntityManager em=emf.createEntityManager();
		    em.getTransaction().begin();
		    TypedQuery<Runlego> query = em.createQuery("SELECT l.run FROM Runlego l ORDER BY l.time DESC", Runlego.class);
			query.setMaxResults(1);
			Runlego latestRunlego=query.getSingleResult();
			em.close();
		        return latestRunlego;
	}
	
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
	
	
	@Path("/setcurrentspeed")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CurrentSpeed setCurrentSpeed(CurrentSpeed ob) {
		System.out.println(ob);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(ob);
	    em.getTransaction().commit();		
		return ob;
	}
	
	 @GET
	    @Path("/latest")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CurrentSpeed getLatestSpeeds() {
	        EntityManager em = emf.createEntityManager();
	        TypedQuery <CurrentSpeed> query = em.createQuery("SELECT c FROM CurrentSpeed c ORDER BY c.Id DESC", CurrentSpeed.class);
	        query.setMaxResults(1);
	        CurrentSpeed latestSpeed = query.getSingleResult();
	        em.close();
	        return latestSpeed;
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




	 
	 
	@Path("/getfollow/{inid}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getfollowValues(@PathParam("inid") int id) {
		 EntityManager em=emf.createEntityManager();
		    em.getTransaction().begin();
		    
		   // Query q = em.createQuery("SELECT s FROM FollowPath s WHERE s.Id IN (SELECT MAX(s1.Id) FROM FollowPath s1 GROUP BY s1.targetIntensityRange) ORDER BY s.Id DESC");
		    Query q = em.createQuery("SELECT f FROM linefollow f WHERE f.targetIntensity= :id ORDER BY f.Id DESC ").setMaxResults(1);
		    q.setParameter("id", id);

		    List<LineFollow> list=q.getResultList();
			em.getTransaction().commit();		
			return list.toString();
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


	
	@GET
    @Path("/getmotorspeeds/{leftSpeed_1}/{rightSpeed_1}/{leftSpeed_2}/{rightSpeed_2}")
    @Produces(MediaType.APPLICATION_JSON)
    public LineFollow getMotorSpeeds(@PathParam("leftSpeed_1") int leftSpeed_1, @PathParam("rightSpeed_1") int rightSpeed_1,@PathParam("leftSpeed_2") int leftSpeed_2, @PathParam("rightSpeed_2") int rightSpeed_2) {
        return new LineFollow(leftSpeed_1, rightSpeed_1,leftSpeed_2, rightSpeed_2);
    }
	

}
