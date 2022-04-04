package br.natan.VenturaHR.Model.Domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "vagas")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Integer id;
    @ManyToOne
    private Empresa empresa;
    @OneToMany(mappedBy = "vaga",cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Resposta> respostas;
    private String cargo;
    private String cidade;
    private String perfil;
    private String descricao;
    private String salario;
    private String forma_contratacao;
    private Integer idUsuarioCriador;
    private String nomeEmpresa;
    private Integer empresaCriadora;

    public Integer getEmpresaCriadora() {
        return empresaCriadora;
    }

    public void setEmpresaCriadora(Integer empresaCriadora) {
        this.empresaCriadora = empresaCriadora;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Collection<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(Collection<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Integer getIdUsuarioCriador() {
        return idUsuarioCriador;
    }

    public void setIdUsuarioCriador(Integer idUsuarioCriador) {
        this.idUsuarioCriador = idUsuarioCriador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getForma_contratacao() {
        return forma_contratacao;
    }

    public void setForma_contratacao(String forma_contratacao) {
        this.forma_contratacao = forma_contratacao;
    }
}
