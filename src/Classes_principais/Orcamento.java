package Classes_principais;

public class Orcamento extends OrdemDeServico {
    String cpfMecanico;
    Double valor;
    String servicos;
    Boolean concluido;
        
    public Orcamento(String placa_cliente, String problema,String cpfMecanico, Double valor, String servicos) {
    	super(placa_cliente,problema);
        this.cpfMecanico = cpfMecanico;
        this.valor = valor;
        this.servicos = servicos;
        this.concluido = false;
    }
    
}
