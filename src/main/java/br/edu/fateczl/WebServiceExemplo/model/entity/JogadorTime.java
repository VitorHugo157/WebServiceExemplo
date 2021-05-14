package br.edu.fateczl.WebServiceExemplo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "JogadorTime")
@NamedNativeQuery(
        name = "JogadorTime.udfJogadorIdade",
        query = "SELECT codigo, nomeJogador, sexo, altura, dt_nasc, idade, id, nome, cidade "
                +"FROM fn_jogadoridade(?1)",
        resultClass = JogadorTime.class
)
public class JogadorTime {

    @Id
    @Column
    private Integer codigo;

    @Column
    private String nomeJogador;

    @Column
    private String sexo;

    @Column
    private Float altura;

    @Column
    private String dt_nasc;

    @Column
    private Integer idade;

    @Column
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cidade;

    public JogadorTime() {}

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getNomeJogador() { return nomeJogador; }
    public void setNomeJogador(String nomeJogador) { this.nomeJogador = nomeJogador; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public Float getAltura() { return altura; }
    public void setAltura(Float altura) { this.altura = altura; }

    public String getDt_nasc() { return dt_nasc; }
    public void setDt_nasc(String dt_nasc) { this.dt_nasc = dt_nasc; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return "JogadorTime{" +
                "codigo=" + codigo +
                ", nomeJogador='" + nomeJogador + '\'' +
                ", sexo='" + sexo + '\'' +
                ", altura=" + altura +
                ", dt_nasc='" + dt_nasc + '\'' +
                ", idade=" + idade +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
