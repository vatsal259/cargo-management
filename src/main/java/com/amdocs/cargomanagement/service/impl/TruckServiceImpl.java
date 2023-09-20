package com.amdocs.cargomanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.entity.Truck;
import com.amdocs.cargomanagement.exception.IdNotFoundException;
import com.amdocs.cargomanagement.repo.CargoRepository;
import com.amdocs.cargomanagement.repo.TruckRepository;
import com.amdocs.cargomanagement.service.TruckService;

@Service
public class TruckServiceImpl implements TruckService 
{
	private TruckRepository truckRepo;
	
	private CargoRepository cargoRepo;
	// TODO Auto-generated constructor stub
	
	@Autowired
	public TruckServiceImpl(TruckRepository truckRepo,CargoRepository cargoRepo)
	{
		//super();
		this.truckRepo=truckRepo;
		this.cargoRepo = cargoRepo;
	}
	
	@Override
	public Truck saveTruck(int cargoid, Truck truck) throws IdNotFoundException
	{
		//Exception handling
		Cargo cargo = cargoRepo.findById(cargoid).orElse(null);
		if(cargo==null)
		{
			throw new IdNotFoundException("Cargo Id not present");
		}
		truck.setCargo(cargo);
		return truckRepo.save(truck);
	}

	@Override
	public List<Truck> getAllTruck() 
	{
		return truckRepo.findAll();
	}

	@Override
	public Truck getTruckId(Long id)
	{
		return truckRepo.findById(id).orElse(null);
	}

	@Override
	public Truck updateTruck(Long id, Truck truck) 
	{
		Truck existingTruck=truckRepo.findById(id).orElse(null);
		if(existingTruck!=null)
		{
			existingTruck.setCapacity(truck.getCapacity());
			existingTruck.setModel(truck.getModel());
			existingTruck.setRegistration(truck.getRegistration());
			return truckRepo.save(existingTruck);
		}
		return null;
	}
	
	@Override
	public void deleteTruck(Long id)
	{
		truckRepo.deleteById(id);
	}

}
