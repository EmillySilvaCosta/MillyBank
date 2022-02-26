
public class Recarga{
	//variaveis de instancia
	//private double valor;
	private String numero;
	private double credito = 0.00;
	
//	public double getValor() {
//		return valor;
//	}
	// 'this.valor' -> a variável do atributo
	// 'valor' -> o argumento do método set
	// atribuindo o valor informado pelo argumento, para a variável do atributo.
//	public void setValor(int valor) {
//		this.valor = valor;
//	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	public void recarga(double valor) {
		credito += valor;
	}
	
}
