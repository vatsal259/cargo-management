package com.amdocs.cargomanagement.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.repo.CargoRepository;
import com.amdocs.cargomanagement.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService
{
	@Autowired
	private CargoRepository cargoRepo;
	
	@Override
	public boolean saveCargo(Cargo cargo) 
	{
		Cargo cargoSave = cargoRepo.save(cargo);
		boolean flag=false;
		if(cargoSave != null)
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Cargo> getAllCargo() 
	{
		List<Cargo> cargoRecords = cargoRepo.findAll();
		return cargoRecords;
	}

	@Override
	public Cargo getCargoId(int id) 
	{
		Optional<Cargo> cargoId=cargoRepo.findById(id);
		Cargo cargo=cargoId.get();
		return cargo;
	}

	@Override
	public boolean updateCargo(Cargo st)
	{
		return saveCargo(st);
	}

	@Override
	public boolean deleteCargo(int id) 
	{
		Cargo cargo=getCargoId(id);
		boolean flag=false;
		if(cargo!=null)
		{
			cargoRepo.delete(cargo);
			flag=true;
		}
		return flag;
	}
	
}
