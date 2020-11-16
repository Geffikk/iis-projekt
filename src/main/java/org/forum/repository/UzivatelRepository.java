package org.forum.repository;

import org.forum.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UzivatelRepository extends JpaRepository<Uzivatel, String> {


}
