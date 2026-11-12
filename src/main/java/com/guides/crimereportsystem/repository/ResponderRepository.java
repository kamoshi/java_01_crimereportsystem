package com.guides.crimereportsystem.repository;

import com.guides.crimereportsystem.entity.Responder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponderRepository extends JpaRepository<Responder, Long> {
}
