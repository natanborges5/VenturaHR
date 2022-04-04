package br.natan.VenturaHR.Model.Domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "repostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Vaga vaga;
    private Integer id_Usuario;
    private Integer id_Vaga;
    private String reposta;
    private String datatime;
    private Float indice;

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Integer getId_Vaga() {
        return id_Vaga;
    }

    public void setId_Vaga(Integer id_Vaga) {
        this.id_Vaga = id_Vaga;
    }

    public String getReposta() {
        return reposta;
    }

    public void setReposta(String reposta) {
        this.reposta = reposta;
    }

    public Float getIndice() {
        return indice;
    }

    public void setIndice(Float indice) {
        this.indice = indice;
    }
}
