/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.simona.magazzino;

/**
 *
 * @author s.megna
 */
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

public class BorsaMapper {
    private String colore;
    private String anno;
    private int id;
        
  @DynamoDBHashKey(attributeName="Id")
  public int getId() { return id;}
  public void setId(int id) {this.id = id;}

  @DynamoDBAttribute(attributeName="colore")  
    public String getColore() { return colore;}
public void setColore(String colore) {this.colore = colore;}

 @DynamoDBAttribute(attributeName="anno")  
    public String getAnno() { return anno;}
public void setAnno(String anno) {this.anno = anno;}
}