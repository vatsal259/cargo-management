package com.amdocs.cargomanagement.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cargo 
{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cargoId;
	
	@JsonManagedReference
	@OneToMany(mappedBy= "cargo", cascade = CascadeType.ALL)
	private List<Truck> truck=new ArrayList<>();
	
	@Column(name = "TYPE")
	private String cargoType;
	
	@Column(name = "ISSUER")
	private String cargoIssuer;
	
	public int getCargoId() {
		return cargoId;
	}

	public List<Truck> getTruck() {
		return truck;
	}

	public String getCargoType() {
		return cargoType;
	}

	public String getCargoIssuer() {
		return cargoIssuer;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public void setTruck(List<Truck> truck) {
		this.truck = truck;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public void setCargoIssuer(String cargoIssuer) {
		this.cargoIssuer = cargoIssuer;
	}

	public Cargo(int cargoId, String cargoType, String cargoIssuer) 
	{
		this.cargoId = cargoId;
		this.cargoType = cargoType;
		this.cargoIssuer = cargoIssuer;
	}

	public Cargo() 
	{
		
	}
	
}
