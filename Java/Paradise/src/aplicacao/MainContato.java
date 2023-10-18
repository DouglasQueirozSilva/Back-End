package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.ContatoDAO;
import model.Cliente;
import model.Contato;

public class MainContato {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		ContatoDAO contatoDAO = new ContatoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		

		int opcao = 0, id = 0;

		String email = "", mensagem = "", nome_completo = "", telefone = "";

		do {

			System.out.println("\n============================== Contatos =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				
				System.out.println("Digite o id do cliente:");
				int id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome completo:");
				nome_completo = s.nextLine();
				System.out.println("Digite a mensagem:");
				mensagem = s.nextLine();
				System.out.println("Digite um telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();

                Cliente cliente1 = clienteDAO.readById(id_cliente);
                Contato contato1 = new Contato(cliente1, nome_completo, mensagem, telefone, email);
                
				contatoDAO.create(contato1);
				break;
			case 2:

				for (Contato u : contatoDAO.read()) {
					System.out.println(u.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id do contato:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				int id_cliente1 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome completo:");
				nome_completo = s.nextLine();
				System.out.println("Digite a mensagem:");
				mensagem = s.nextLine();
				System.out.println("Digite um telefone:");
				telefone = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();

                Cliente cliente2 = clienteDAO.readById(id_cliente1);
                
                Contato contato2 = new Contato(id, cliente2, nome_completo, mensagem, telefone, email);
               
				contatoDAO.update(contato2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				contatoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Contato destino3 = contatoDAO.readById(id);

				System.out.println(destino3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
