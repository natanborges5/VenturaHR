package br.natan.VenturaHR.Model.Repository;

import br.natan.VenturaHR.Model.Domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.email = :email and u.senha = :senha")
    Usuario autenticarUser(String email, String senha);
    @Query("select u from Usuario u where u.email = :email")
    Usuario obterUserPorEmail(String email);
}
