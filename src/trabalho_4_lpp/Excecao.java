package trabalho_4_lpp;

public class Excecao extends Exception {
    
    public Excecao(){
        super("Dados Inválidos");
    }
    
    public Excecao(String mensagem){
        super(mensagem);
    }
}
