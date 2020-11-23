package org.forum.service;

import org.forum.entity.Prispevok;
import org.forum.entity.Vlakno;
import org.forum.entity.Uzivatel;
import org.forum.repository.PrispevokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PrispevokServiceImpl implements PrispevokService{

    @Autowired
    private PrispevokRepository prispevokRepository;

    @Autowired
    private VlaknoService vlaknoService;

    @Autowired
    private UzivatelService uzivatelService;

    @Override
    public Prispevok findPrispevokById(int id) {
        Optional<Prispevok> optional = prispevokRepository.findById(id);
        Prispevok prispevok = null;
        if(optional.isPresent()) {
            prispevok = optional.get();
        }else {
            throw new RuntimeException("Prispevok s id: " + id + " nebol najdeny!");
        }
        return prispevok;
    }

    @Override
    public List<Prispevok> findAll() {
        return prispevokRepository.findAll();
    }

    @Override
    public Set<Prispevok> findRecent() {
        return prispevokRepository.findTop5ByOrderByDatumZalozeniaDesc();
    }

    @Override
    public Set<Prispevok> findAllByOrderByDatumZalozeniaDesc() {
        return prispevokRepository.findAllByOrderByDatumZalozeniaDesc();
    }

    @Override
    public Set<Prispevok> findByZakladatelPrispevku(Uzivatel uzivatel) {
        return prispevokRepository.findByZakladatelPrispevku(uzivatel);
    }

    @Override
    public Set<Prispevok> findByVlaknoPrispevku(int idVlakna) {
        return findByVlaknoPrispevku(vlaknoService.findOne(idVlakna));
    }

    @Override
    public Set<Prispevok> findByVlaknoPrispevku(Vlakno vlakno) {
        return prispevokRepository.findByVlaknoPrispevku(vlakno);
    }

    @Override
    public void save(Prispevok prispevok) {
        prispevokRepository.save(prispevok);
    }

    @Override
    public void delete(int id) {
        delete(findPrispevokById(id));
    }

    @Override
    public void delete(Prispevok prispevok) {
        prispevokRepository.delete(prispevok);
    }

    @Override
    public void save(String kontent, String meno, int idVlakna) {
        Prispevok post = new Prispevok();
        post.setVlaknoPrispevku(vlaknoService.findOne(idVlakna));
        post.setZakladatelPrispevku(uzivatelService.findByUzivatelskeMeno(meno));
        post.setObsah(kontent);
        save(post);
    }
}
