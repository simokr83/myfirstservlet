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
public class Scarpa {
	private String colore;
	private String anno;
	private int id;
	private String numero;
	public Scarpa(int id){
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
	public String getNumero(){
		return numero;
	}
	public void setNumero(String numero){
		this.numero=numero;
	}
}



