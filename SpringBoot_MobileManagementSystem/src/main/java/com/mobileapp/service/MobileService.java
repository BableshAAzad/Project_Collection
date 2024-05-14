package com.mobileapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mobileapp.entity.Mobile;
import com.mobileapp.utility.ResponseStructure;

public interface MobileService {
	
	ResponseEntity<ResponseStructure<Mobile>> addMobile(Mobile mobile);
	
	ResponseEntity<ResponseStructure<Mobile>> findMobileById(Long mobileId);
	
	ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobiles();
	
	ResponseEntity<ResponseStructure<Mobile>> deleteMobileById(Long mobileId);
	
	ResponseEntity<ResponseStructure<Mobile>> updateMobileById(Long mobileId, Mobile mobile);
 }
