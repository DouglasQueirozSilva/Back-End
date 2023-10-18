package aplicacao;

import java.util.Scanner;

import dao.DestinoDAO;
import model.Destino;

public class MainDestino {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
	 DestinoDAO destinoDAO = new DestinoDAO();

		int opcao = 0, id = 0;

		String volta = "", ida = "";

		do {

			System.out.println("\n============================== DESTINOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite um valor:");
				float valor = s.nextFloat();
				s.nextLine();
				System.out.println("Digite o local da partida:");
				ida = s.nextLine();
				System.out.println("Digite a volta:");
				volta = s.nextLine();

				Destino destino1 = new Destino(valor, ida, volta);

				destinoDAO.create(destino1);
				break;
			case 2:

				for (Destino u : destinoDAO.read()) {
					System.out.println(u.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				s.nextLine();
				System.out.println("Digite o local da partida:");
				ida = s.nextLine();
				System.out.println("Digite a volta:");
				volta = s.nextLine();

				Destino destino2 = new Destino(id, valor, ida, volta);

		        destinoDAO.update(destino2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				destinoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Destino destino3 = destinoDAO.readById(id);

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
