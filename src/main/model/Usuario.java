public class Usuario {
    private int id;
    private String nome;
    private String sobreNome;
    private String email;
    private String telefone;
    private String senha;
    private boolean aceitaTermos;
    private String fotoPerfil;

    
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
        return sobreNome;
    }
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

}
