package se.jan.wos.repository;

import se.jan.wos.model.Lager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LagerRepository extends JpaRepository<Lager, Long> {
}