package org.forum.service;

import org.forum.entity.Skupina;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface VlaknoService {

    List<Vlakno> findAll();

    Vlakno findOne(int id);

    Set<Vlakno> findRecent();

    Set<Vlakno> findAllByOrderByDatumZalozeniaDesc();

    Set<Vlakno> findBySkupinaVlakna(Skupina skupina);

    Set<Vlakno> findBySkupinaVlakna(String nazovSkupiny);

    Set<Vlakno> findBySkupinaVlakna(int id);

    Vlakno save(Vlakno vlakno);

    Set<Vlakno> findByZakladatelVlakna(Uzivatel uzivatel);

    void delete(int id);

    void delete(Vlakno vlakno);
}
