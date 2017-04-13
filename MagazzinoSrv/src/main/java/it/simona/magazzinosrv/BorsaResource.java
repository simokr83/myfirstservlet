/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.simona.magazzinosrv;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.logging.Logger;
import it.simona.magazzino.Borsa;
import it.simona.magazzino.BorsaMapper;
import static it.simona.magazzinosrv.ApplicationConfig.listaBorse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author s.megna
 */
//questo path si usa per dire guarda la mia risorsa parte da qui
@Path("borsa")
public class BorsaResource {
    //crea la connessione tra la mia API ed il database dynamo
     private static AmazonDynamoDBClient client;
    //quello che arriva trasformalo in un oggetto UriInfo di nome context e rappresenta il contesto della chiamata fatta dal client
    @Context
    private UriInfo context;

    public BorsaResource(){
  
    }
    public BorsaResource(AmazonDynamoDBClient client){
     this.client=client;
    }
    
    @GET
    //prende l id che arriva sulla risorsa dalla chiamata http 
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //prendo l id dall url e lo trasformo nel paramentro di tipo stringa
    public Response getBorsa(@PathParam("id") Integer id) throws IOException{ 
       System.out.println("GET/borsa/"+id);
        //Mapping resource on DynamoDB table
       DynamoDBMapper db_mapper = new DynamoDBMapper(client);
       
        BorsaMapper borsa = new BorsaMapper();
        try{
            borsa=db_mapper.load(BorsaMapper.class,id);
            Response.status(200).entity(borsa).build();
        }catch (AmazonServiceException ase) 
        {
            System.out.println(ase.getErrorMessage());
            return Response.status(500).entity("{\"Status\":\"Error\"}").build();
}        return null;
}
       //  String jsonBorsa = null;
       // for(Borsa i : listaBorse){
      //Borsa index;
    /*Iterator<Borsa> iterator = listaBorse.iterator();
     while(iterator.hasNext()&& ApplicationConfig.listaBorse.size()<= id ) {
        index = ApplicationConfig.listaBorse.get(id);
        ObjectMapper m = new ObjectMapper();
        m.writeValueAsString(index);
        //andare a prendere dall'array di borse la borsa con id ID
        System.out.println("GET/borsa/"+id);
     }
     if (ApplicationConfig.listaBorse.size()> id) {
        iterator.remove();
     }  
     return jsonBorsa;*/
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     public Response putBorsa(String content) throws IOException{ 
   
         System.out.println("PUT/borsa");
         //questo mi serve per collegare il database
         DynamoDBMapper db_mapper=new DynamoDBMapper(client);
         //questo mi serve per andare a prendere il json del mio webservice quindi farò un'operazione di deserializzazione
         ObjectMapper obj_mapper=new ObjectMapper();
         //Leggo il mio json in formato mapper in maniera tale che questo oggetto possa comunicare con il db                 
         BorsaMapper borsa = obj_mapper.readValue(content,BorsaMapper.class);
         //mi prendo l'id dal json
         borsa.setId(borsa.getId());
         try{
             //salva l'oggetto come leggile dal db
             db_mapper.save(borsa);
             //return Response.created(content.getAbsolutePath()).build();
            return Response.status(201).entity(content).build();
         }
         catch(AmazonServiceException ase){
          // Logger.getLogger(ase.getErrorMessage());
           System.err.println("Failed to retrieve items: ");
             return Response.status(500).build();
         }
     }
/*    @DELETE
    //prende l id che arriva sulla risorsa dalla chiamata http 
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //prendo l id dall url e lo trasformo nel paramentro di tipo stringa
    public void deleteBorsa(@PathParam("id") Integer id) throws IOException{ 
        System.out.println("sono entrata qui dentro");
        String jsonBorsa = null;
        for(Borsa i : listaBorse){
        Borsa b = ApplicationConfig.listaBorse.get(id);
        System.out.println("/n"+"id:"+b.getId()+"/n"+"colore:"+b.getColore()+"/n"+"anno:"+b.getAnno());
        int index= ApplicationConfig.listaBorse.indexOf(b);
        ObjectMapper m = new ObjectMapper();
        ApplicationConfig.listaBorse.remove(index);
    System.out.println("DELETE/borsa/"+id);
      } 
}*/
    /* @POST
    //prende l id che arriva sulla risorsa dalla chiamata http 
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public void pushBorsa(@PathParam("id") Integer id,String content) throws IOException{ 
         //prendo l'elemento in posizione id
         String jsonBorsa = null;
        Borsa index = ApplicationConfig.listaBorse.get(id);
        ObjectMapper m = new ObjectMapper();
        m.writeValueAsString(index);
        //faccio l'update dell'elemento in posizione id
        ObjectMapper mapper=new ObjectMapper();
        Borsa b=mapper.readValue(content,Borsa.class);
        ApplicationConfig.listaBorse.add(b);
        
         System.out.println("POST/borsa/"+id);
     }*/
}
