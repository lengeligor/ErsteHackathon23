package sk.tuke.pegasus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import sk.tuke.pegasus.entity.Klient;
import sk.tuke.pegasus.entity.PlatobnyTerminal;

public interface PlatobnyTerminalRepository extends JpaRepository<PlatobnyTerminal, Long>, QuerydslPredicateExecutor<PlatobnyTerminal> {
}
