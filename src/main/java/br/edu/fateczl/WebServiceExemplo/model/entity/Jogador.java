package br.edu.fateczl.WebServiceExemplo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Jogador")
@NamedNativeQuery(
        name = "Jogador.findJogadoresDataConv",
        query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura, "
                +"CONVERT(CHAR(10), j.dt_nasc, 103) AS dt_nasc, j.id_time, "
                +"t.id, t.nome, t.cidade "
                +"FROM jogador j, times t "
                +"WHERE j.id_time = t.id",
        resultClass = Jogador.class
)
@NamedNativeQuery(
        name = "Jogador.findJogadorDataConv",
        query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura, "
                +"CONVERT(CHAR(10), j.dt_nasc, 103) AS dt_nasc, j.id_time, "
                +"t.id, t.nome, t.cidade "
                +"FROM jogador j, times t "
                +"WHERE j.id_time = t.id "
                +"AND j.codigo = ?1",
        resultClass = Jogador.class
)
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "id_time")
    private Times times;

    public Jogador() {}


    public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public String getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public Times getTimes() {
		return times;
	}
	public void setTimes(Times times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", nomeJogador=" + nomeJogador + ", sexo=" + sexo + ", altura=" + altura
				+ ", dt_nasc=" + dt_nasc + ", times=" + times + "]";
	}
	
}
