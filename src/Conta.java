
public class Conta {
	private static int SEQUENCIAL = 014;
	private static final int AGENCIA_PADRAO = 1;
	protected int agencia;
	protected int conta;
	protected double saldo;
	protected Cliente cliente;
	protected Recarga recarga;
	protected double valorEmprestimo;
	
	
	//construtor
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.conta = Conta.SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public Conta(Cliente cliente, Recarga recarga) {
		this.cliente = cliente;
		this.recarga = recarga;
	}

	public void depositar(Double valor) {
		if(valor != null) {
		this.saldo += valor;
		}
	}

	public void sacar(Double valor) {
		if(valor != null) {
		this.saldo -= valor;
		}
	}

	public void transferir(Double valor, Conta contaDestino) {
		if(valor != null) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		}
	}
	
	public void emprestimo(Double valor) {
		if(valor != null) {
		valorEmprestimo += valor;
		depositar(valor);
		}
	}
	
	public void recarga(Double valor, Cliente cliente) {
		if(valor != null) {
		this.sacar(valor);
		this.cliente.recarga(valor);
		}
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getConta() {
		return conta;
	}

//	public int getConta(Cliente cliente) {
//		// aqui o cliente compoe a conta, todo clinte tem uma conta
//		this.setCliente(cliente);
//		return conta;
//	}
   //metodo para retornar saldo
	public double getSaldo() {
		return saldo;
	}

	public void imprimirExtrato() {
		
		System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Conta: %d", conta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	public void saldoRecarga() {
		System.out.println(String.format("Saldo do celular: %.2f", this.cliente.getCredito()));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
