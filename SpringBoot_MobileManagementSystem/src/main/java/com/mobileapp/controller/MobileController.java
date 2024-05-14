package com.mobileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.entity.Mobile;
import com.mobileapp.service.MobileService;
import com.mobileapp.utility.ResponseStructure;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	@Autowired
	private MobileService mobileService;

	@PostMapping("/addMobile")
	public ResponseEntity<ResponseStructure<Mobile>> addMobile(@RequestBody Mobile mobile) {
		return mobileService.addMobile(mobile);
	}

	@GetMapping("/findMobileById/{mobileId}")
	public ResponseEntity<ResponseStructure<Mobile>> findMobileById(@PathVariable Long mobileId) {
		return mobileService.findMobileById(mobileId);
	}
	
	@GetMapping("/getAllMobiles")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobiles() {
		return mobileService.findAllMobiles();
	}
	
	@DeleteMapping("/deleteMobileById/{mobileId}")
	public ResponseEntity<ResponseStructure<Mobile>> deleteMobileById(@PathVariable Long mobileId) {
		return mobileService.deleteMobileById(mobileId);
	}
	
	@PutMapping("/updateMobileById/{mobileId}")
	public ResponseEntity<ResponseStructure<Mobile>> updateMobileById(@PathVariable Long mobileId,@RequestBody Mobile mobile) {
		return mobileService.updateMobileById(mobileId, mobile);
	}
}
