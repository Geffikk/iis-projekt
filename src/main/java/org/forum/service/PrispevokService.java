package org.forum.service;

import org.forum.entity.Prispevok;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface PrispevokService {

    Prispevok findPrispevokById(int id);

    List<Prispevok> findAll();

    Set<Prispevok> findRecent();

    Set<Prispevok> findAllByOrderByDatumZalozeniaDesc();

    Set<Prispevok> findByZakladatelPrispevku(Uzivatel uzivatel);

    Set<Prispevok> findByVlaknoPrispevku(int idVlakna);

    Set<Prispevok> findByVlaknoPrispevku(Vlakno topic);

    void save(Prispevok prispevok);

    void delete(int id);

    void delete(Prispevok prispevok);

    void save(String kontent,
              String meno,
              int idVlakna);
}
