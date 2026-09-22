package bancohorizonte.org.repository;

import bancohorizonte.org.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>
{

    public List<Conta> findAllByClienteId(Long clienteId);
}
