package DepartamentoTransito;
import java.util.List;
import java.util.ArrayList;

public class Veiculo { 
    int anoFabricacao;
    Pessoa condutor;
    List<Pessoa> passageiros;
    int carga; // para veículos de carga
    boolean temCarga;

    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public Veiculo(int anoFabricacao, Pessoa condutor, List<Pessoa> passageiros, int carga, boolean temCarga) {
        this.anoFabricacao = anoFabricacao;
        this.condutor = condutor;
        this.passageiros = passageiros;
        this.carga = carga;
        this.passageiros = passageiros;
        this.temCarga = temCarga;
    }
}
