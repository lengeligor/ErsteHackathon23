package sk.tuke.pegasus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sk.tuke.pegasus.entity.Karta;

@Repository
public interface KartaRepository extends JpaRepository<Karta, Long>, QuerydslPredicateExecutor<Karta> {
}
