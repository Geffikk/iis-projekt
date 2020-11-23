package org.forum.service;

import org.forum.entity.Skupina;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.forum.repository.VlaknoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VlaknoServiceImpl implements VlaknoService{

    @Autowired
    private VlaknoRepository vlaknoRepository;

    @Autowired
    private SkupinaService skupinaService;


    @Override
    public List<Vlakno> findAll() {
        return vlaknoRepository.findAll();
    }

    @Override
    public Vlakno findOne(int id) {
        Optional<Vlakno> optional = vlaknoRepository.findById(id);
        Vlakno vlakno = null;
        if(optional.isPresent()) {
            vlakno = optional.get();
        }else {
            throw new RuntimeException("Vlakno s id: " + id + " nebolo najdene!");
        }
        return vlakno;
    }

    @Override
    public Set<Vlakno> findRecent() {
        return vlaknoRepository.findTop5ByOrderByDatumZalozeniaDesc();
    }

    @Override
    public Set<Vlakno> findAllByOrderByDatumZalozeniaDesc() {
        return vlaknoRepository.findAllByOrderByDatumZalozeniaDesc();
    }

    @Override
    public Set<Vlakno> findBySkupinaVlakna(Skupina skupina) {
        return vlaknoRepository.findBySkupinaVlakna(skupina);
    }

    @Override
    public Set<Vlakno> findBySkupinaVlakna(String nazovSkupiny) {
        return findBySkupinaVlakna(skupinaService.findByNazov(nazovSkupiny));
    }

    @Override
    public Set<Vlakno> findBySkupinaVlakna(int id) {
        return findBySkupinaVlakna(skupinaService.findOne(id));
    }

    @Override
    public Vlakno save(Vlakno vlakno) {
        return vlaknoRepository.save(vlakno);
    }

    @Override
    public Set<Vlakno> findByZakladatelVlakna(Uzivatel uzivatel) {
        return vlaknoRepository.findByZakladatelVlakna(uzivatel);
    }

    @Override
    public void delete(int id) {
        delete((findOne(id)));
    }

    @Override
    public void delete(Vlakno vlakno) {
        vlaknoRepository.delete(vlakno);
    }
}
