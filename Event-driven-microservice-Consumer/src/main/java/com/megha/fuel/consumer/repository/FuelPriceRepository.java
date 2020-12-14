package com.megha.fuel.consumer.repository;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.megha.fuel.consumer.model.FuelPrice;

/**
 * Repository class for Fuel Price
 * @author Megha Sharma
 *
 */
//This annotation annotates classes at persistant layer and acts as database repository.
@Repository
public interface FuelPriceRepository extends JpaRepository<FuelPrice, String>{

	@Query("Select price from fuel where city=?")
	List<FuelPrice> findByCity(String city);
	
	@Scheduled(cron="0 */24 * * *")
	public default void doScheduleUpdate() throws SQLException { 
		for(FuelPrice fp : findAll()) {
			Double updFuelPrice = (fp.getFuelPrice() * 0.5);
			fp.setFuelPrice(updFuelPrice);
			save(fp);
		}
	}

}
