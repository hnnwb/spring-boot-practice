package com.practice.jpa.repository.second;

import com.practice.jpa.entity.second.SecondMultiTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondMultiTableRepository extends JpaRepository<SecondMultiTable, Long> {
}
