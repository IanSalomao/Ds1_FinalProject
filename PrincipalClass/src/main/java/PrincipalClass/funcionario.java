package PrincipalClass;

public class funcionario extends pessoa{
    String Senha;

    public funcionario(String Senha, String CPF, String Nome) {
        super(CPF, Nome);
        this.Senha = Senha;
    }
    
}
