//extends herda as informações da classe conta(pai)
public class ContaPoupanca extends Conta {
    

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	/*
	 * public static int SEQUENCIAL = 014; public ContaPoupanca() { //a cada conta
	 * que for criada será somado mais um ao valor de 014 super.conta =
	 * SEQUENCIAL++; }
	 */
	public void imprimirExtrato() {
		System.out.println("Conta Poupança");
		System.out.println(String.format("Conta: %d", super.conta));
		//referenciando o objeto da classe mãe que esta na class conta.java
		super.imprimirExtrato();
		
	}
}
