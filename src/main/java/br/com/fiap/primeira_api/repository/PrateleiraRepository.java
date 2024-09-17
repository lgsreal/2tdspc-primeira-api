package br.com.fiap.primeira_api.repository;

import br.com.fiap.primeira_api.model.Prateleira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrateleiraRepository extends JpaRepository<Prateleira, Long> {
}
