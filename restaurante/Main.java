import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Pedido> pedidos = new ArrayList<>();
        Cliente[] clientes = new Cliente[0];

        int loopMenu = 0;

        do {
            System.out.println("--------- BEM-VINDO AO RESTAURANTE SABOR GOURMET ---------");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Visualizar clientes");
            System.out.println("[3] Cardápio");
            System.out.println("[4] Fazer pedido");
            System.out.println("[5] Consultar pedidos");
            System.out.println("[6] Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("---------- CADASTRO DE CLIENTES ----------");
                    System.out.println();
                    System.out.print("Quantos clientes você deseja cadastrar? ");
                    int quantidadeClientes = sc.nextInt();

                    for (int i = 0; i < quantidadeClientes; i++) {
                        System.out.print("Insira o nome: ");
                        String nome = sc.next();

                        System.out.print("Insira o endereço: ");
                        String endereco = sc.next();

                        System.out.print("Insira o telefone: ");
                        String telefone = sc.next();

                        clientes = new Cliente[quantidadeClientes];
                        clientes[i].registrarCliente(nome, endereco, telefone);

                        System.out.println();
                        System.out.println("----------------------------------------------------");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("---------- LISTA DE CLIENTES ----------");
                    for (Cliente cliente : clientes) {
                        cliente.visualizarCliente();
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("---------- CARDÁPIO ----------");
                    System.out.println("[1] Entrada - Batata-frita - R$ 29,90");
                    System.out.println("[2] Entrada - Coxinha de frango - R$ 9,90");
                    System.out.println("[3] Prato Principal - Bife à milanesa - R$ 49,90");
                    System.out.println("[4] Prato Principal - Estrogonofe - R$ 59,90");
                    System.out.println("[5] Sobremesa - Petit Gateau - R$ 29,90");
                    System.out.println("[6] Bebida - Sex on the Beach - R$ 14,90");
                    break;
                case 5:
                    int opt = 0;
                    ArrayList<Integer> numeroPrato = new ArrayList<Integer>();

                    while (opt == 0) {
                        System.out.println("---------- FAZER PEDIDO ----------");
                        System.out.print("Insira o nome do cliente: ");
                        String nomeCliente = sc.next();

                        System.out.print("Insira o código do prato disponível no cardápio: ");
                        numeroPrato.add(sc.nextInt());

                        System.out.println("Inserir mais um prato? [1] Sim [2] Não");
                        int option = sc.nextInt();

                        if (option == 2) {
                            ArrayList<Item> itensPedidos = new ArrayList<>();
                            Pedido pedido;

                            Optional<Cliente> clienteEncontrado =
                                    Arrays.stream(clientes)
                                            .filter(c -> Objects.equals(c.getNome(), nomeCliente))
                                            .findFirst();

                            if(clienteEncontrado.isPresent()) {
                                pedido = new Pedido(itensPedidos, clienteEncontrado.get(), "Em preparação");
                                pedidos.add(pedido);
                            }

                            opt = 1;
                        }
                    };
                    break;
                case 6:
                    loopMenu = 1;
                    break;
                default:
                    System.out.println("Ocorreu um erro!");
            }

        } while (loopMenu == 0);
    }
}
