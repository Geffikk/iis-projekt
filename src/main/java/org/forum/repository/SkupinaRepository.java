package org.forum.repository;

import org.forum.entity.Skupina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkupinaRepository extends JpaRepository<Skupina, Integer> {

    Skupina findByNazov(String nazov);
}
