package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DestinoDAO;
import model.Cliente;
import model.Compra;
import model.Destino;

public class MainCompra {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();

		int opcao = 0, id = 0;

		do {

			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o id do cliente:");
				int id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id destino:");
				int id_destino = s.nextInt();
				s.nextLine();

				Cliente cliente1 = clienteDAO.readById(id_cliente);
				Destino destino1 = destinoDAO.readById(id_destino);

				Compra compra1 = new Compra(cliente1, destino1);

				compraDAO.create(compra1);
				break;
			case 2:

				for (Compra u : compraDAO.read()) {
					System.out.println(u.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id da compra:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				int id_cliente2 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id destino:");
				int id_destino2 = s.nextInt();
				s.nextLine();

				Cliente cliente2 = clienteDAO.readById(id_cliente2);
				Destino destino2 = destinoDAO.readById(id_destino2);

				Compra compra2 = new Compra(id, cliente2, destino2);

				compraDAO.update(compra2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				compraDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Compra compra3 = compraDAO.readById(id);

				System.out.println(compra3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
