package org.java.app.repo;

import org.java.app.pojo.Cap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapRepo extends JpaRepository<Cap, Integer> {

}
