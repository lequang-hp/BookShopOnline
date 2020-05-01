package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.HistoryEntity;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long>{
	List<HistoryEntity> findByUserId(Long userID);
	List<HistoryEntity> findByBillId(Long billID);
}
