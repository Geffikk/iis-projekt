package org.forum.repository;

import org.forum.entity.Vlakno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VlaknoRepository extends JpaRepository<Vlakno, Integer> {
}
