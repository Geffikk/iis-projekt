package org.forum.service;

import org.forum.entity.Prispevok;
import org.forum.repository.PrispevokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrispevokServiceImpl implements PrispevokService{

    @Autowired
    private PrispevokRepository prispevokRepository;


    @Override
    public List<Prispevok> getAllPrispevky() {
        return prispevokRepository.findAll();
    }

    @Override
    public void savePrispevok(Prispevok prispevok) {
        this.prispevokRepository.save(prispevok);
    }

    @Override
    public Prispevok getPrispevokById(Integer id) {
        Optional<Prispevok> optional = prispevokRepository.findById(id);
        Prispevok prispevok = null;
        if(optional.isPresent()) {
            prispevok = optional.get();
        }else {
            throw new RuntimeException("Prispevok s id: " + id + " nebol najdeny!");
        }
        return prispevok;
    }
}
