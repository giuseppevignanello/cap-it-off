package org.java.app.repo;

import org.java.app.pojo.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SizeRepo extends JpaRepository<Size, Integer> {

}
