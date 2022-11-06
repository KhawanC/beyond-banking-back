package bynd.banking.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bynd.banking.servico.model.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

}
