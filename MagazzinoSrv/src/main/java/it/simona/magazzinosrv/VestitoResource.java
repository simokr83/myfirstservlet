/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.simona.magazzinosrv;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**   
 *
 * @author s.megna
 */
@Path("vestito")
public class VestitoResource {
    @Context
    private UriInfo context;
    public VestitoResource(){}
    public VestitoResource(Object[] obj){}
     @GET
     //prende l id che arriva sulla risorsa dalla chiamata http 
     @Path("{id}")
     @Produces(MediaType.APPLICATION_JSON)
     public String getVestito(@PathParam("id") String id){
     String result=  "{\"id\":127,\"colore\":\"verde\",\"taglia\":40}";
     System.out.println("GET/vestito"+id);
         return result;
     }
     
     @PUT
     @Path("{id}")
     @Consumes(MediaType.APPLICATION_JSON)
    public void putVestito(@PathParam("id") String id){
     System.out.println("PUT/vestito"+id);

}
}