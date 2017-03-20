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
@Path("scarpa")
public class ScarpaResouce {
    @Context
    private UriInfo content;
    public ScarpaResouce(){
    }
    public ScarpaResouce(Object[] obj){
    }
    @GET
     //prende l id che arriva sulla risorsa dalla chiamata http 
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
     //prendo l id dall url e lo trasformo nel paramentro di tipo stringa
    public String getScarpa(@PathParam("id") String id){
        String result=  "{\"id\":125,\"colore\":\"rosso\",\"numero\":39}";
         System.out.println("GET/scarpa/"+id);
        return result;
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putScarpa(@PathParam("id") String id){
    System.out.println("PUT/scarpa"+id);
    }
    }

