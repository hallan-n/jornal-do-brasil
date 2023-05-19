package model;
import java.util.Date;

public class Publicacao {
    private int id;
    private String titulo;
    private String categoria;
    private String caminho;
    private Date dataCriacao;


    public Publicacao(String titulo, String categoria, String caminho, Date dataCriacao){
        this.titulo = titulo;
        this.categoria = categoria;
        this.caminho = caminho;
        this.dataCriacao = dataCriacao;
    }

    public Publicacao(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getCaminho() {
        return caminho;
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }


    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
