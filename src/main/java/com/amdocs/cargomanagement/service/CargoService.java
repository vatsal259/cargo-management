package com.amdocs.cargomanagement.service;

import java.util.List;
import com.amdocs.cargomanagement.entity.Cargo;

public interface CargoService 
{
	public boolean saveCargo(Cargo cargo);
	public List<Cargo> getAllCargo();
	public Cargo getCargoId(int id);
	public boolean updateCargo(Cargo st);
	public boolean deleteCargo(int id);
	
}
