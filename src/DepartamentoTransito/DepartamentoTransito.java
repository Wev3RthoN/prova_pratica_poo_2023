package DepartamentoTransito;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartamentoTransito {
     List<Rodovia> rodovias = new ArrayList<>();
    List<Acidente> acidentes = new ArrayList<>();

    public void cadastrarRodovia(String sigla, String periculosidade) {
        Rodovia rodovia = new Rodovia(sigla, periculosidade);
        rodovias.add(rodovia);
    }

    public void cadastrarAcidente(Acidente acidente) {
        acidentes.add(acidente);
    }

    public List<Acidente> listarAcidentesEmbriagados() {
        // Retorna a lista de acidentes com condutores embriagados
        List<Acidente> acidentesEmbriagados = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.veiculosEnvolvidos) {
                if (veiculo.condutor.embriagado) {
                    acidentesEmbriagados.add(acidente);
                    break;  // Apenas uma vez por acidente
                }
            }
        }
        return acidentesEmbriagados;
    }

    public Map<String, Integer> mostrarQuantidadeAcidentesPericulosidade() {
        // Retorna um mapa com a quantidade de acidentes por periculosidade
        Map<String, Integer> periculosidadeCount = new HashMap<>();
        for (Acidente acidente : acidentes) {
            String periculosidade = acidente.rodovia.periculosidade;
            periculosidadeCount.put(periculosidade, periculosidadeCount.getOrDefault(periculosidade, 0) + 1);
        }
        return periculosidadeCount;
    }

    // Adicione métodos para as demais operações conforme necessário
}