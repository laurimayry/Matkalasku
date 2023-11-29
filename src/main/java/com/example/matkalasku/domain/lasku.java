package com.example.matkalasku.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Lasku {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate pvm;
    private String lahtoOsoite;
    private String maaranpaa;
    private long kilometrit;
    private double korvaus;
    
    public Lasku() {}

    
	public Lasku(LocalDate pvm, String lahtoOsoite, String maaranpaa, long kilometrit, double korvaus) {
		super();
		this.pvm = pvm;
		this.lahtoOsoite = lahtoOsoite;
		this.maaranpaa = maaranpaa;
		this.kilometrit = kilometrit;
		this.korvaus = korvaus;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getPvm() {
		return pvm;
	}


	public void setPvm(LocalDate pvm) {
		this.pvm = pvm;
	}


	public String getLahtoOsoite() {
		return lahtoOsoite;
	}


	public void setLahtoOsoite(String lahtoOsoite) {
		this.lahtoOsoite = lahtoOsoite;
	}


	public String getMaaranpaa() {
		return maaranpaa;
	}


	public void setMaaranpaa(String maaranpaa) {
		this.maaranpaa = maaranpaa;
	}


	public long getKilometrit() {
		return kilometrit;
	}


	public void setKilometrit(long kilometrit) {
		this.kilometrit = kilometrit;
	}

	
	public double getKorvaus() {
		return korvaus;
	}


	public void setKorvaus(double korvaus) {
		this.korvaus = korvaus;
	}

	


	@Override
	public String toString() {
		return "Lasku [id=" + id + ", pvm=" + pvm + ", lahtoOsoite=" + lahtoOsoite + ", maaranpaa=" + maaranpaa + ", kilometrit=" + kilometrit + ", korvaus=" + korvaus + "]";

	}
}
