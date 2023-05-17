public class Configuracao {
    private int id;
    private boolean notificacao;
    private boolean som;
    private boolean fotoPerfil;
    private boolean menssagem;
    private boolean mostrarNumero;
    private boolean mostrarEmail;
    private String tema;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public boolean isNotificacao() {
        return notificacao;
    }
    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }


    public boolean isSom() {
        return som;
    }
    public void setSom(boolean som) {
        this.som = som;
    }


    public boolean isFotoPerfil() {
        return fotoPerfil;
    }
    public void setFotoPerfil(boolean fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }


    public boolean isMenssagem() {
        return menssagem;
    }
    public void setMenssagem(boolean menssagem) {
        this.menssagem = menssagem;
    }


    public boolean isMostrarNumero() {
        return mostrarNumero;
    }
    public void setMostrarNumero(boolean mostrarNumero) {
        this.mostrarNumero = mostrarNumero;
    }


    public boolean isMostrarEmail() {
        return mostrarEmail;
    }
    public void setMostrarEmail(boolean mostrarEmail) {
        this.mostrarEmail = mostrarEmail;
    }
    

    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }

}
