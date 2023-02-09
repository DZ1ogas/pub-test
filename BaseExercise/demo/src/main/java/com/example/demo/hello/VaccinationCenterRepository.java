package com.example.demo.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<Doctor, String> {
}
