package com.amdocs.cargomanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Truck 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "truckId")
	private long truckId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="truck")
	private Cargo cargo;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "capacity")
	private String capacity;

	@Override
	public String toString() {
		return "[truckId=" + truckId + " | model=" + model + " | registration=" + registration + " | capacity="
				+ capacity + "]";
	}
	
	
}
