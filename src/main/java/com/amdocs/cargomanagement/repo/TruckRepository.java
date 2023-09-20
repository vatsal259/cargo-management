package com.amdocs.cargomanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.cargomanagement.entity.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>
{

}
