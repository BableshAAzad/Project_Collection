package com.mobileapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobileapp.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Long> {

}
