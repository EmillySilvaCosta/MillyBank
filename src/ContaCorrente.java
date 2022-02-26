
public class ContaCorrente extends Conta {
	
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	/*
	 * public static int SEQUENCIAL = 035;
	 * 
	 * public ContaCorrente() { super.conta = SEQUENCIAL++; }
	 */
	 
	@Override
	public void imprimirExtrato() {
		System.out.println("Conta Corrente");
		
		super.imprimirExtrato();
	}
}
