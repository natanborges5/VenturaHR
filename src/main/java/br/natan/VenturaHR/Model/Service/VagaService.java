package br.natan.VenturaHR.Model.Service;

import br.natan.VenturaHR.Model.Domain.Empresa;
import br.natan.VenturaHR.Model.Domain.Vaga;
import br.natan.VenturaHR.Model.Repository.EmpresaRepository;
import br.natan.VenturaHR.Model.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public Collection<Vaga> obterLista(){
        return (Collection<Vaga>) vagaRepository.findAll();
    }
    public  void incluir(Vaga vaga) {
        vagaRepository.save(vaga);
    }

    public Vaga obterPorId(Integer id) {
        return vagaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        vagaRepository.deleteById(id);
    }
    public Collection<Vaga> obterListaPorEmpresa(Integer id){
        return (Collection<Vaga>) vagaRepository.obterVagasPorEmpresa(id);
    }

}
