package cz.burios.ux.cancel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cz.burios.ux.cancel.models.CarModel;

import org.apache.log4j.*;

@RestController
public class TestApiController {
	
	private static Logger logger = LogManager.getLogger(TestApiController.class);

	@PreAuthorize("hasRole('ROLE_SITE_USER')")
	@RequestMapping(value = "/secure/api/carModel", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CarModel> getCarModel(@RequestParam("make") String make, @RequestParam("model") String model) {
		logger.info("Car Maker: " + make);
		logger.info("Car Model: " + model);

		CarModel carEntity = new CarModel();
		carEntity.setMaker("Honda");
		carEntity.setModel("Accord");
		carEntity.setYear(2016);
		carEntity.setPrice(19667.28f);

		ResponseEntity<CarModel> retVal = new ResponseEntity<CarModel>(carEntity, HttpStatus.OK);
		return retVal;
	}
}
