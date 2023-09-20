package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.cargomanagement.entity.Truck;
import com.amdocs.cargomanagement.service.impl.TruckServiceImpl;

@RestController
@RequestMapping("/truck")
public class TruckController 
{
	
	private TruckServiceImpl truckService;
	

	@Autowired
	public TruckController(TruckServiceImpl truckService)
	{
		this.truckService=truckService;
	}

	@PostMapping("/insert/{cargoId}")
	public Truck saveTruck(@RequestBody Truck truck, @PathVariable int cargoId)
	{
		Truck check=null;
		try
		{
			check = truckService.saveTruck(cargoId, truck);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return check;
	}

	@GetMapping("/alltrucks")
	public List<Truck> getAllTruck()
	{
		return truckService.getAllTruck();
	}
	
	@GetMapping("/{truckid}")
	public Truck getTruckId(@PathVariable Long truckid)
	{
		return truckService.getTruckId(truckid);
	}
	
	@PutMapping("/update/{truckid}")
	public Truck  updateTruck(@PathVariable Long truckid, @RequestBody Truck truck)
	{
		return truckService.updateTruck(truckid, truck);
	}
	
	@DeleteMapping("/delete/{truckid}")
	public void deleteTruck(@PathVariable Long truckid)
	{
		truckService.deleteTruck(truckid);
	}
}
