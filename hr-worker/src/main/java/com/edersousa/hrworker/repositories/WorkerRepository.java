package com.edersousa.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersousa.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
