package javaSpring.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaSpring.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
