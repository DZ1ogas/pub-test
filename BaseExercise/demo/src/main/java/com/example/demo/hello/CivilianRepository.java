package com.example.demo.hello;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface for the Student to connect with the JPA Student
// Only basic implementations are inherited
public interface CivilianRepository extends JpaRepository<Civilian, String> {
}
