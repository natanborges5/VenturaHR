package br.natan.VenturaHR.Model.Service;

import br.natan.VenturaHR.Model.Domain.Resposta;
import br.natan.VenturaHR.Model.Domain.Vaga;
import br.natan.VenturaHR.Model.Repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    public Collection<Resposta> obterLista(){
        return (Collection<Resposta>) respostaRepository.findAll();
    }
    public  void incluir(Resposta resposta) {
        respostaRepository.save(resposta);
    }

    public  Resposta obterPorId(Integer id) {
        return respostaRepository.findById(id).orElse(null);
    }

    public  void excluir(Integer id) {
        respostaRepository.deleteById(id);
    }
    public Collection<Resposta> obterListaPorVaga(Integer id){
        return (Collection<Resposta>) respostaRepository.obterRespostaPorVaga(id);
    }
}
