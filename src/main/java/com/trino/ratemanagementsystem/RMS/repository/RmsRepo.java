package com.trino.ratemanagementsystem.RMS.repository;

import com.trino.ratemanagementsystem.RMS.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RmsRepo extends JpaRepository<Rate,Long> {

    Rate findByRateId(Long id);
}
