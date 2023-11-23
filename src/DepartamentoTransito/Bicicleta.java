package DepartamentoTransito;
import java.util.ArrayList;
public class Bicicleta extends Veiculo {
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    public Bicicleta(int anoFabricacao, Pessoa condutor) {
        super(anoFabricacao, condutor, new ArrayList<>(), 0, false);
    }
}
