package org.forum.service;

import org.forum.entity.Skupina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkupinaService {

    List<Skupina> findAll();

    Skupina findOne(int id);

    Skupina findByNazov(String nazov);

    Skupina save(Skupina skupina);

    void delete(int id);

    void delete(Skupina skupina);

}
