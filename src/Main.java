import java.util.Locale;
import java.util.Scanner;

//import java.io.IOException;
public class Main {
	static Scanner scan;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// resource para suprimir avisos relativos ao uso de recursos do tipo
		// Closeable(mensagem que marcou scan)

		scan = new Scanner(System.in);
		System.out.println(">>>Bem-vindo ao MillyBank!<<<");
		Integer opcao = 0;
		Cliente cliente = new Cliente();
		ContaCorrente cc = null;
		ContaPoupanca poupanca = new ContaPoupanca(cliente);
		do {

			System.out.print(
					"\nQual opera��o voc� deseja realizar?\n1-Abrir conta\n2-Ver extrato\n3-Transferir\n4-Depositar\n5-Recarga\n6-Empr�stimo\n7-Sair\n");

			opcao = Integer.parseInt(scan.nextLine());

			// Object depositar;
			switch (opcao) {

			case 1:
				// estou puxando os dados do cliente
				System.out.println("Por favor, digite seu nome: ");
				cliente.setNome(scan.nextLine());
				System.out.println("Por favor, digite seu CPF: ");
				cliente.setCpf(scan.nextLine());
				System.out.println("Por favor, digite seu celular: ");
				cliente.setNumero(scan.nextLine());

				cc = new ContaCorrente(cliente);

				System.out.println(">>>Parab�ns, sua conta foi aberta com sucesso!<<<");
				break;

			case 2:
				if (cc != null) {
					System.out.println("===EXTRATO===\n");
					// imprimir valor guardado ou recebido
					cc.imprimirExtrato();
					poupanca.imprimirExtrato();
				}
				break;

			case 3:
				if (cc != null) {
					System.out.println("Qual o valor que voc� deseja transferir? A transfer�ncia ser� feita da sua conta corrente para poupan�a.");
					cc.transferir(lerValor(), poupanca);
					System.out.println("Transfer�ncia feita com sucesso!");
				}
				break;

			case 4:
				System.out.print("Deseja depositar em qual conta?\n 1.Corrente 2.Poupan�a");
				opcao = lerOpcao();
				if (opcao != null) {
					switch (opcao) {
					case 1:
						if (cc != null) {
							System.out.print("Digite o valor que voc� deseja depositar na Conta Corrente: ");
							cc.depositar(lerValor());
						}
						break;
					case 2:
						if (cc != null) {
							System.out.print("Digite o valor que voc� deseja depositar na Conta Poupan�a: ");
							poupanca.depositar(lerValor());
						}
						break;
					default:
						break;
					}

				}
				break;

			case 5:
				
				if (cc != null) {
					System.out.print("Ser� descontado da sua conta corrente. Digite o valor da recarga: ");
					cc.recarga(lerValor(), cliente);
					System.out.printf("Recarga feita com sucesso! No numero: %s%n", cliente.getNumero());
					cc.saldoRecarga();
				}
				break;

			case 6:
				if (cc != null) {
					System.out.print("Qual o valor do empr�stimo que voc� quer? :");
					// chamando o metodo ler valor
					cc.emprestimo(lerValor());
					System.out.print("Valor liberado com sucesso na sua Conta Corrente!");
				}
				break;

			case 7:

				System.out.println("Encerrando servi�o.");
				break;

			default:
				System.out.println("Por favor, digite uma op��o v�lida.");
				break;
			}
		} while (opcao != 7);

	}

	private static Double lerValor() {

		try {
			return Double.parseDouble(scan.nextLine());
		} catch (Exception e) {
			System.out.println("Valor inv�lido. Opera��o cancelada.");
		}
		return null;
	}

	private static Integer lerOpcao() {
		try {

			return Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			System.out.println("Valor inv�lido. Opera��o cancelada.");
		}
		return null;
	}

}
