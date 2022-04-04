package br.natan.VenturaHR.Model.Service;

import br.natan.VenturaHR.Model.Domain.Empresa;
import br.natan.VenturaHR.Model.Domain.Usuario;
import br.natan.VenturaHR.Model.Repository.EmpresaRepository;
import br.natan.VenturaHR.Model.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Collection<Empresa> obterLista(){
        return (Collection<Empresa>) empresaRepository.findAll();
    }
    public  void incluir(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public Empresa obterPorId(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        empresaRepository.deleteById(id);
    }
}
