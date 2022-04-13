package PrincipalClass;

public class cliente extends pessoa{

   String Email;
   int Telefone;
   String Endereco;
   String Placa;

    public cliente(String Email, int Telefone, String Endereco, String Placa, String CPF, String Nome) {
        super(CPF, Nome);
        this.Email = Email;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Placa = Placa;
    }
    
}
