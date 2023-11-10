package sk.tuke.pegasus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import sk.tuke.pegasus.entity.Transakcia;
import sk.tuke.pegasus.entity.Ucet;

public interface UcetRepository extends JpaRepository<Ucet, Long>, QuerydslPredicateExecutor<Ucet> {
}
