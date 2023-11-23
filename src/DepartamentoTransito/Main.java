package DepartamentoTransito;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        DepartamentoTransito departamento = new DepartamentoTransito();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Rodovia");
            System.out.println("2 - Cadastrar Acidente");
            System.out.println("3 - Listar Acidentes com Condutores Embriagados");
            System.out.println("4 - Mostrar Quantidade de Acidentes por Periculosidade");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a sigla da rodovia:");
                    String siglaRodovia = scanner.next();
                    System.out.println("Digite o grau de periculosidade (alto, médio, baixo):");
                    String periculosidadeRodovia = scanner.next();
                    departamento.cadastrarRodovia(siglaRodovia, periculosidadeRodovia);
                    break;

                case 2:
                    System.out.println("Digite o número de vítimas fatais:");
                    int vitimasFatais = scanner.nextInt();
                    System.out.println("Digite o número de feridos:");
                    int feridos = scanner.nextInt();
                    System.out.println("Digite o mês do acidente:");
                    String mesAcidente = scanner.next();
                    System.out.println("Digite a sigla da rodovia do acidente:");
                    String siglaRodoviaAcidente = scanner.next();
                    Rodovia rodoviaAcidente = null;

                    for (Rodovia rodovia : departamento.rodovias) {
                        if (rodovia.sigla.equals(siglaRodoviaAcidente)) {
                            rodoviaAcidente = rodovia;
                            break;
                        }
                    }

                    if (rodoviaAcidente == null) {
                        System.out.println("Rodovia não encontrada.");
                        break;
                    }

                    List<Veiculo> veiculosEnvolvidos = new ArrayList<>();
                    System.out.println("Digite o número de veículos envolvidos:");
                    int numVeiculos = scanner.nextInt();

                    for (int i = 0; i < numVeiculos; i++) {
                        System.out.println("Veículo " + (i + 1) + ":");
                        System.out.println("Digite o ano de fabricação:");
                        int anoFabricacao = scanner.nextInt();
                        System.out.println("Digite o nome do condutor:");
                        String nomeCondutor = scanner.next();
                        System.out.println("Digite a idade do condutor:");
                        int idadeCondutor = scanner.nextInt();
                        System.out.println("Digite o sexo do condutor:");
                        String sexoCondutor = scanner.next();
                        System.out.println("O condutor estava embriagado? (true/false):");
                        boolean embriagadoCondutor = scanner.nextBoolean();

                        Pessoa condutor = new Pessoa(nomeCondutor, idadeCondutor, sexoCondutor, embriagadoCondutor);

                        System.out.println("Digite o número de passageiros:");
                        int numPassageiros = scanner.nextInt();
                        List<Pessoa> passageiros = new ArrayList<>();

                        for (int j = 0; j < numPassageiros; j++) {
                            System.out.println("Passageiro " + (j + 1) + ":");
                            System.out.println("Digite o nome do passageiro:");
                            String nomePassageiro = scanner.next();
                            System.out.println("Digite a idade do passageiro:");
                            int idadePassageiro = scanner.nextInt();
                            System.out.println("Digite o sexo do passageiro:");
                            String sexoPassageiro = scanner.next();

                            Pessoa passageiro = new Pessoa(nomePassageiro, idadePassageiro, sexoPassageiro, false);
                            passageiros.add(passageiro);
                        }

                        System.out.println("O veículo é uma bicicleta? (true/false):");
                        boolean isBicicleta = scanner.nextBoolean();

                        if (isBicicleta) {
                            veiculosEnvolvidos.add(new Bicicleta(anoFabricacao, condutor));
                        } else {
                            System.out.println("Digite a carga do veículo (para veículos de carga):");
                         boolean cargaVeiculo = scanner.nextBoolean();
                            veiculosEnvolvidos.add(new Veiculo(anoFabricacao, condutor, passageiros, 0,cargaVeiculo));
                        }
                    }

                    Acidente novoAcidente = new Acidente(rodoviaAcidente, vitimasFatais, feridos, mesAcidente, veiculosEnvolvidos);
                    departamento.cadastrarAcidente(novoAcidente);

                    break;

                case 3:
                    // Implemente a listagem de acidentes com condutores embriagados aqui
                    List<Acidente> acidentesEmbriagados = departamento.listarAcidentesEmbriagados();
                    System.out.println("Acidentes com Condutores Embriagados:");
                    for (Acidente acidente : acidentesEmbriagados) {
                        System.out.println("Rodovia: " + acidente.rodovia.sigla + ", Mês: " + acidente.mes);
                    }
                    break;

                case 4:
                    // Implemente a exibição da quantidade de acidentes por periculosidade aqui
                    Map<String, Integer> periculosidadeCount = departamento.mostrarQuantidadeAcidentesPericulosidade();
                    System.out.println("Quantidade de Acidentes por Periculosidade:");
                    for (Map.Entry<String, Integer> entry : periculosidadeCount.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        }
       
        
    }
}