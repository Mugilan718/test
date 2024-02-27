package in.codifi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codifi.entity.Entity1;

public interface Repository extends JpaRepository<Entity1, Long> {
	
} 