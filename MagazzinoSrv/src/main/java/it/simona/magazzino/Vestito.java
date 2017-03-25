/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.simona.magazzinoservices;

import javax.ws.rs.Path;

/**
 *
 * @author s.megna
 */

public class Vestito {
	private String colore;
	private String anno;
	private int id;
	private String taglia;
	public Vestito(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getAnno(){
		return anno;
	}
	public void setAnno(String anno){
		this.anno=anno;
	}
	public String getColore(){
		return colore;
	}
	public void setColore(String colore){
		this.colore=colore;
	}
	public String getTaglia(){
		return taglia;
	}
	public void setNumero(String taglia){
		this.taglia=taglia;
	}
}

