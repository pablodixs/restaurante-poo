import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Pedido> pedidos = new ArrayList<>();
        Cliente[] clientes = null;
        Cliente cliente = null;
        Pedido pedido;

        int loopMenu = 0;

        do {
            System.out.println("--------- BEM-VINDO AO RESTAURANTE SABOR GOURMET ---------");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Visualizar clientes");
            System.out.println("[3] Cardápio");
            System.out.println("[4] Fazer pedido");
            System.out.println("[5] Consultar pedidos");
            System.out.println("[6] Alterar status de pedido");
            System.out.println("[7] Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("---------- CADASTRO DE CLIENTES ----------");
                    System.out.println();
                    System.out.print("Quantos clientes você deseja cadastrar? ");
                    int quantidadeClientes = sc.nextInt();
                    clientes = new Cliente[quantidadeClientes];

                    for (int i = 0; i < quantidadeClientes; i++) {
                        System.out.print("Insira o nome: ");
                        String nome = sc.next();

                        System.out.print("Insira o endereço: ");
                        String endereco = sc.next();

                        System.out.print("Insira o telefone: ");
                        String telefone = sc.next();

                        clientes[i] = new Cliente();
                        clientes[i].registrarCliente(nome, endereco, telefone);

                        System.out.println();
                        System.out.println("----------------------------------------------------");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("---------- LISTA DE CLIENTES ----------");
                    for (Cliente clnt : clientes) {
                        clnt.visualizarCliente();
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
                case 4:
                    int opt = 1;
                    ArrayList<Integer> numeroPrato = new ArrayList<>();

                    System.out.println("---------- FAZER PEDIDO ----------");
                    System.out.print("Insira o nome do cliente: ");
                    String nomeCliente = sc.next();

                    cliente = verificarSeClienteExiste(nomeCliente, clientes);

                    pedido = new Pedido(cliente, "Em preparação");

                    while (opt == 1) {
                        System.out.print("Insira o código do prato disponível no cardápio: ");
                        numeroPrato.add(sc.nextInt());

                        System.out.println("Inserir mais um prato? [1] Sim [2] Não");
                        opt = sc.nextInt();
                    }

                    for(int codigoItem : numeroPrato) {
                        pedido.adicionarItem(registrarItem(codigoItem));
                    }

                    pedido.calcularTotal();
                    pedidos.add(pedido);

                    break;
                case 5:
                    System.out.println();
                    System.out.println("---------- PEDIDOS ----------");

                    for(Pedido pds : pedidos) {
                        System.out.println("Cliente: " + pds.getCliente().getNome());
                        System.out.println("Status: " + pds.getStatus());
                        System.out.println("Pratos pedidos");
                        var itens = pds.getItens();
                        for(Item item : itens) {
                            item.getDetalhesItem();
                            System.out.println("-");
                        }
                        System.out.println("Total do pedido: R$ " + pds.getTotal());
                        System.out.println();
                        System.out.println("----------------------------------------------------");
                    }

                    break;
                case 6:
                    System.out.println("---------- ALTERAR STATUS ----------");
                    System.out.println("Insira o nome do cliente: ");
                    String clienteName = sc.next();
                    Cliente clienteAlt;

                    clienteAlt = verificarSeClienteExiste(clienteName, clientes);

                    Optional<Pedido> pedidoAlt = pedidos.stream()
                            .filter(c -> c.getCliente().getNome().equals(clienteAlt.getNome()))
                            .findFirst();

                    if(pedidoAlt.isPresent()) {
                        System.out.println("Selecione o novo status: [1] Pronto para entrega [2] Entregue");
                        int status = sc.nextInt();

                        switch (status) {
                            case 1:
                                pedidoAlt.get().atualizarStatus("Pronto para entrega");
                                break;
                            case 2:
                                pedidoAlt.get().atualizarStatus("Entregue");
                                break;
                        }

                        System.out.println("******** STATUS ATUALIZADO COM SUCESSO! ******** ");
                    }
                    break;
                case 7:
                    loopMenu = 1;
                    break;
                default:
                    System.out.println("Ocorreu um erro!");
            }

        } while (loopMenu == 0);
    }

    public static Item registrarItem(int codigo) {
        Item item = new Item();

        switch (codigo) {
            case 1:
                item.setNome("Batata-frita");
                item.setCategoria("Entrada");
                item.setPreco(29.90);

                return item;
            case 2:
                item.setNome("Coxinha de frango");
                item.setCategoria("Entrada");
                item.setPreco(9.90);

                return item;
            case 3:
                item.setNome("Bife à milanesa");
                item.setCategoria("Prato principal");
                item.setPreco(49.90);

                return item;
            case 4:
                item.setNome("Estrogonofe");
                item.setCategoria("Prato principal");
                item.setPreco(59.90);

                return item;
            case 5:
                item.setNome("Petit Gateau");
                item.setCategoria("Sobremesa");
                item.setPreco(29.90);

                return item;
            case 6:
                item.setNome("Sex on the beach");
                item.setCategoria("Bebida");
                item.setPreco(14.90);

                return item;
        }

        return item;
    }

    public static Cliente verificarSeClienteExiste(String nome, Cliente[] clientes) {
        Optional<Cliente> clienteEncontrado =
                Arrays.stream(clientes)
                        .filter(c -> Objects.equals(c.getNome(), nome))
                        .findFirst();

        if (clienteEncontrado.isPresent()) {
            return clienteEncontrado.get();
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }
}
