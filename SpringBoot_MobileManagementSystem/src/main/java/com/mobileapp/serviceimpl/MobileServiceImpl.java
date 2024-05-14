package com.mobileapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobileapp.entity.Mobile;
import com.mobileapp.exception.MobileAllReadyExistException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.repository.MobileRepository;
import com.mobileapp.service.MobileService;
import com.mobileapp.utility.ResponseStructure;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> addMobile(Mobile mobile) {
		Optional<Mobile> mobileOptional = mobileRepository.findById(mobile.getMobileId());
		if (mobileOptional.isEmpty()) {
			Mobile savedMobile = mobileRepository.save(mobile);
			ResponseStructure<Mobile> responseStructure = new ResponseStructure<Mobile>();
			responseStructure.setMessage("Mobile saved successfully done");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(savedMobile);
			return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new MobileAllReadyExistException(
					"MobileId : " + mobile.getMobileId() + ", Already present in databse ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> findMobileById(Long mobileId) {
		Optional<Mobile> mobileOptional = mobileRepository.findById(mobileId);
		if (mobileOptional.isPresent()) {
			Mobile mobile = mobileOptional.get();
			ResponseStructure<Mobile> responseStructure = new ResponseStructure<Mobile>();
			responseStructure.setMessage("Mobile Founded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(mobile);
			return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MobileNotFoundException(
					"MobileId : " +mobileId + ", not present in databse ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobiles() {
		List<Mobile> mobiles = mobileRepository.findAll();
		ResponseStructure<List<Mobile>> responseStructure = new ResponseStructure<List<Mobile>>();
		responseStructure.setMessage("Mobile Founded");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(mobiles);
		return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> deleteMobileById(Long mobileId) {
		Optional<Mobile> mobileOptional = mobileRepository.findById(mobileId);
		if (mobileOptional.isPresent()) {
			Mobile mobile = mobileOptional.get();
			mobileRepository.delete(mobile);
			ResponseStructure<Mobile> responseStructure = new ResponseStructure<Mobile>();
			responseStructure.setMessage("Mobile deleted successfully done");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(mobile);
			return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MobileNotFoundException(
					"MobileId : " +mobileId + ", not present in databse ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> updateMobileById(Long mobileId, Mobile mobile) {
		Optional<Mobile> mobileOptional = mobileRepository.findById(mobileId);
		if (mobileOptional.isPresent()) {
			Mobile existingMobile = mobileOptional.get();
			mobile.setMobileId(existingMobile.getMobileId());
			Mobile updatedMobile = mobileRepository.save(mobile);
			
			ResponseStructure<Mobile> responseStructure = new ResponseStructure<Mobile>();
			responseStructure.setMessage("Mobile updated successfully done");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(updatedMobile);
			return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MobileNotFoundException(
					"MobileId : " +mobileId + ", not present in databse ");
		}
	}

}
