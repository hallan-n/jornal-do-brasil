package model;
public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String senha;
    private boolean aceitaTermos;
    private String fotoPerfil;
    private Endereco endereco = new Endereco();
    
    public int getId() {        
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSobreNome() {
        return sobrenome;
    }
    public void setSobreNome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public boolean isAceitaTermos() {
        return aceitaTermos;
    }
    public void setAceitaTermos(boolean aceitaTermos) {
        this.aceitaTermos = aceitaTermos;
    }


    public String getFotoPerfil() {
        return fotoPerfil;
    }
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }


    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
