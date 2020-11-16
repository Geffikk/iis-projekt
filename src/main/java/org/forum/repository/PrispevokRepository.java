package org.forum.repository;

import org.forum.entity.Prispevok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrispevokRepository extends JpaRepository<Prispevok, Integer> {
}
