package com.example.springlearning.repository;

import com.example.springlearning.model.ClassRoomModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomModel, Integer> {
}
