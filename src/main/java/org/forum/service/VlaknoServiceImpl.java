package org.forum.service;

import org.forum.entity.Vlakno;
import org.forum.repository.VlaknoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VlaknoServiceImpl implements VlaknoService{

    @Autowired
    private VlaknoRepository vlaknoRepository;

    @Override
    public List<Vlakno> getAllVlakna() {
        return vlaknoRepository.findAll();
    }

    @Override
    public void saveUzivatel(Vlakno vlakno) {
        this.vlaknoRepository.save(vlakno);
    }

    @Override
    public Vlakno getVlaknoById(Integer id) {
        Optional<Vlakno> optional = vlaknoRepository.findById(id);
        Vlakno vlakno = null;
        if(optional.isPresent()) {
            vlakno = optional.get();
        }else {
            throw new RuntimeException("Vlakno s id: " + id + " nebolo najdene!");
        }
        return vlakno;
    }
}
