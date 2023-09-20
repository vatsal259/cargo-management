package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.service.impl.CargoServiceImpl;

@Controller
public class CargoController 
{
	@Autowired
	private CargoServiceImpl cargoService;
	
	@RequestMapping("/cargo")
	public String loadForm(Model model)
	{
		Cargo cargo =new Cargo();
		model.addAttribute("cargo", cargo);
		return "cargo";
	}
	
	@RequestMapping("/insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo, Model model)
	{
		boolean saveCargo = cargoService.saveCargo(cargo);
		String msg="";
		if(saveCargo)
		{
			msg="Data Inserted SuccessFully";
		}
		else
		{
			msg="Data Not Inserted";
		}
		model.addAttribute("msg", msg);
		return "cargo";
	}
	
	@RequestMapping("/viewAllCargo")
	public String viewAllCargo(Model model)
	{
		List<Cargo> allCargo=cargoService.getAllCargo();
		model.addAttribute("allCargo", allCargo);
		return "viewCargo";
	}
	
	@RequestMapping("/deleteCargo")
	public String deleteCargo(@RequestParam("cargoId") int id, Model model)
	{
		boolean flag =cargoService.deleteCargo(id);
		if(flag)
		{
			return "redirect:/viewAllCargo";
		}
		else
		{
			return "redirect:/viewAllCargo";
		}
	}
	
	@RequestMapping("editCargo")
	public String editCargo(@RequestParam("cargoId") int id, Model model)
	{
		Cargo cargo=cargoService.getCargoId(id);
		model.addAttribute("cargo", cargo);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateCargo(Cargo cargo)
	{
		boolean updateCargo = cargoService.updateCargo(cargo);
		return "redirect:/viewAllCargo";
	}
}
