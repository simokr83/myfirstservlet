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
public class Borsa {
	private String colore;
	private String anno;
	private int id;
	
        public Borsa(){
            
        }
	public Borsa(int id){
		this.id=id;
	}
        public Borsa(int id,String colore,String anno){
		this.id=id;
                this.colore=colore;
                this.anno=anno;
	}
        public Borsa(String colore,String anno){
                this.colore=colore;
                this.anno=anno;
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
}
