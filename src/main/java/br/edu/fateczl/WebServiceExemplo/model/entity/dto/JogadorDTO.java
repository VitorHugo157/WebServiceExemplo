package br.edu.fateczl.WebServiceExemplo.model.entity.dto;

public class JogadorDTO {

    private Integer codigo;
    private String nomeJogador;
    private String sexo;
    private Float altura;
    private String dt_nasc;
    private Integer idade;
    private TimesDTO times;

    public JogadorDTO() {}

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

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public TimesDTO getTimes() { return times; }
    public void setTimes(TimesDTO times) { this.times = times; }

    @Override
    public String toString() {
        return "JogadorDTO{" +
                "codigo=" + codigo +
                ", nomeJogador='" + nomeJogador + '\'' +
                ", sexo='" + sexo + '\'' +
                ", altura=" + altura +
                ", dt_nasc='" + dt_nasc + '\'' +
                ", idade=" + idade +
                ", times='" + times + '\'' +
                '}';
    }
}
