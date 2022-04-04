package br.natan.VenturaHR.Model.Repository;

import br.natan.VenturaHR.Model.Domain.Resposta;
import br.natan.VenturaHR.Model.Domain.Vaga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RespostaRepository extends CrudRepository<Resposta,Integer> {
    @Query("from Resposta  u where u.id_Vaga = :id")
    Collection<Resposta> obterRespostaPorVaga(Integer id);
}
