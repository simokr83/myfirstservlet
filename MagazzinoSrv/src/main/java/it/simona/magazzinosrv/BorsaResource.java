/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.simona.magazzinosrv;

import it.simona.magazzino.Borsa;
import java.util.ArrayList;
import javax.json.Json;
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
//questo path si usa per dire guarda la mia risorsa parte da qui
@Path("borsa")
public class BorsaResource {
    //quello che arriva trasformalo in un oggetto UriInfo di nome context e rappresenta il contesto della chiamata fatta dal client
     @Context
     private UriInfo context;
     private int id;
    public BorsaResource(){
    }
    
    public BorsaResource(Object [] obj){
        obj=new Borsa[id];
     
        }
    @GET
    //prende l id che arriva sulla risorsa dalla chiamata http 
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //prendo l id dall url e lo trasformo nel paramentro di tipo stringa
    public String getBorsa(@PathParam("id") String id){
        String result = "{\"id\":123,\"colore\":\"giallo\"}";
    // for(int i=0; i < obj.length; i++)
    //   if(obj.item(i).getId(“id”))
   //cella = lista_td.item(i);
            
        //andare a prendere dall'array di borse la borsa con id ID
        System.out.println("GET/borsa/"+id);
        
      
        return result;
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
     public void putBorsa(@PathParam("id") String id){ 
         //andare a inserire nell'array di borse la borsa con id ID
    System.out.println("PUT/borsa/"+id);
 
     }
}
