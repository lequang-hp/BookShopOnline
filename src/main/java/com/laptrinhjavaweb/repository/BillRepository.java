package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{

}
