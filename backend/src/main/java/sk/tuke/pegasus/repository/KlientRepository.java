package sk.tuke.pegasus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sk.tuke.pegasus.entity.Klient;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long>, QuerydslPredicateExecutor<Klient> {
}
