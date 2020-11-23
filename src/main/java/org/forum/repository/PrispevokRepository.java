package org.forum.repository;

import org.forum.entity.Prispevok;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PrispevokRepository extends JpaRepository<Prispevok, Integer> {

    Set<Prispevok> findByZakladatelPrispevku(Uzivatel user);

    Set<Prispevok> findByVlaknoPrispevku(Vlakno topic);

    Set<Prispevok> findAllByOrderByDatumZalozeniaDesc();

    Set<Prispevok> findTop5ByOrderByDatumZalozeniaDesc();
}
