package org.forum.repository;

import org.forum.entity.Skupina;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VlaknoRepository extends JpaRepository<Vlakno, Integer> {

    Set<Vlakno> findBySkupinaVlakna(Skupina skupina);

    Set<Vlakno> findByZakladatelVlakna(Uzivatel uzivatel);

    Set<Vlakno> findAllByOrderByDatumZalozeniaDesc();

    Set<Vlakno> findTop5ByOrderByDatumZalozeniaDesc();

}
