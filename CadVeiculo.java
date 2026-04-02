import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main() {
    IO.println("Bem vindo ao Sistema CadVeiculos");
    String menu = """
            MENU DE OPÇÕES
            1 - Cadastrar Veículo;
            2 - Listar Veículos;
            3 - Remover Veículo;
            4 - Editar Veículo;
            0 - Sair
            """;
    int opcao;
    do {
        IO.println(menu);
        opcao = Input.scanInt("Digite a opção desejada: ");
        switch (opcao) {
            case 1 -> {
                cadastrar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 2 -> {
                listar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 3 -> {
                excluir();
                IO.readln("Pressione Enter para Continuar");
            }
            case 4 -> {
                editar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 0 -> {
                IO.println("Volte sempre!!!");
            }
            default -> {
                IO.println("Opção Inválida");
                IO.readln("Pressione Enter para Continuar");
            }

        }
    } while (opcao != 0);

}

void excluir() {
    listar();
    int indice = Input.scanInt("Digite o ínidice do veículo à ser removido: ");
    if (indice > veiculos.size() || indice <= 0)
        IO.println("Veículo não encontrado");
    else {
        veiculos.remove(indice - 1);
        IO.println("Veículo removido com sucesso!");
    }
}

void cadastrar() {
    String veiculo = IO.readln("Digite o nome do novo veículo: ");
    veiculo = veiculo.trim();

    if (veiculo.isEmpty())
        IO.println("Nome do veículo inválido!");
    else {

        boolean jaExiste = false;

        for (String v : veiculos) {
            if (v.equalsIgnoreCase(veiculo)) {
                jaExiste = true;
                break;
            }
        }

        if (jaExiste) {
            IO.println("Erro: Esse veículo já está cadstrado!");
        } else {
            veiculos.add(veiculo);
            IO.println("veiculo cadstrado com sucesso!");
        }
    }

}

void editar() {
    listar();
    String nomeAntigo = IO.readln("Digite o nome do veículo que desja editar: ");

    int indiceEncontrado = -1;

    for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i).equalsIgnoreCase(nomeAntigo)) {
            indiceEncontrado = i;
            break;
        }
    }

    if (indiceEncontrado != -1) {
        String novoNome = IO.readln("Digite o novo nome para o veículo: ");
        novoNome = novoNome.trim();

        if (novoNome.isEmpty()) {
            IO.println("Nome inválido!");
        } else {
            veiculos.set(indiceEncontrado, novoNome);
            IO.println("Veículo atualizado com sucesso!");
        }
    } else {
        IO.println("Veículo não encontrado na lista.");
    }
}

void listar() {
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
}
