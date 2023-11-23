package DepartamentoTransito;
import java.util.List;


public class Acidente { 
    Rodovia rodovia;
    int vitimasFatais;
    int feridos;
    String mes;
    List<Veiculo> veiculosEnvolvidos;

    public Acidente(Rodovia rodovia, int vitimasFatais, int feridos, String mes, List<Veiculo> veiculosEnvolvidos) {
        this.rodovia = rodovia;
        this.vitimasFatais = vitimasFatais;
        this.feridos = feridos;
        this.mes = mes;
        this.veiculosEnvolvidos = veiculosEnvolvidos;
    }
}
