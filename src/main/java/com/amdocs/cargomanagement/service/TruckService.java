package com.amdocs.cargomanagement.service;

import java.util.List;
import com.amdocs.cargomanagement.entity.Truck;
import com.amdocs.cargomanagement.exception.IdNotFoundException;


public interface TruckService 
{
	public Truck saveTruck(int cargoid,Truck truck)throws IdNotFoundException;
	public List<Truck> getAllTruck();
	public Truck getTruckId(Long id);
	public Truck updateTruck(Long id, Truck truck);
	public void deleteTruck(Long id);
}
