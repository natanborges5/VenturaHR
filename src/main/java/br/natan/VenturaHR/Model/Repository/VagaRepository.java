package br.natan.VenturaHR.Model.Repository;

import br.natan.VenturaHR.Model.Domain.Usuario;
import br.natan.VenturaHR.Model.Domain.Vaga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Integer> {
    @Query("from Vaga  u where u.empresaCriadora = :id")
    Collection<Vaga> obterVagasPorEmpresa(Integer id);
}
