/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s.megna
 */


package it.simona.microservice;
        
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.sun.net.httpserver.HttpServer;
import it.simona.magazzinosrv.BorsaResource;
import it.simona.magazzinosrv.Ping;
//import it.simona.magazzinosrv.ScarpaResource;
//import it.simona.magazzinosrv.VestitoResource;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Microservice  {
    
    static AmazonDynamoDBClient client = new AmazonDynamoDBClient();
    
    public static void main(String[] args)
    {
        if ((args.length == 1) && (args[0].equals("local")))
        {
            System.out.println("Starting Jersey REST-full Service with JDK HTTP Server ...");
            System.out.println("DynamoDB on local machine");
            System.out.println("http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html");
            client.withEndpoint("http://localhost:8000");
        }
        else 
        {
            System.out.println("Starting Jersey REST-full Service with JDK HTTP Server ...");
            System.out.println("DynamoDB on AWS");
            client.withRegion(Regions.EU_WEST_1);
        }
        URI baseUri = UriBuilder.fromUri("http://localhost/v1").port(8080).build();
        ResourceConfig config = new ResourceConfig();
        config.register(new Ping());
        config.register(new BorsaResource(client));
     //   config.register(new CarResource(client));
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
}
