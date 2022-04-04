package br.natan.VenturaHR.Model.Repository;

import br.natan.VenturaHR.Model.Domain.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
}
