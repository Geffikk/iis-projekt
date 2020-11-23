package org.forum.service;

import org.forum.entity.Uzivatel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UzivatelService {

    List<Uzivatel> findAll();

    Uzivatel findOne(int id);

    Uzivatel findByUzivatelskeMeno(String uzivatelskeMeno);

    Uzivatel save(Uzivatel uzivatel);
}