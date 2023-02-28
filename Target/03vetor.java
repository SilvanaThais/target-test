import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FaturamentoMensal {

    public static void main(String[] args) {
        //Caminho do arquivo JSON
        String fileName = "C:\\Users\\User\\Desktop\\faturamento.json";

        try {
            //Lê o arquivo JSON
            FileReader reader = new FileReader(fileName);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            //Cria um array para guardar os valores de faturamento
            List<Double> faturamentoDiario = new ArrayList<>();

            //Percorre o objeto do arquivo JSON
            JSONArray dias = (JSONArray) jsonObject.get("dias");
            for (int i = 0; i < dias.size(); i++) {
                JSONObject dia = (JSONObject) dias.get(i);

                //Adiciona o valor do faturamento ao array
                faturamentoDiario.add((Double) dia.get("faturamento"));
            }

            //Calcula o valor mínimo e máximo de faturamento
            double min = faturamentoDiario.get(0);
            double max = faturamentoDiario.get(0);
            for (double valor : faturamentoDiario) {
                if (valor < min) {
                    min = valor;
                } else if (valor > max) {
                    max = valor;
                }
            }

            //Calcula a média de faturamento
            double total = 0;
            int contador = 0;
            for (double valor : faturamentoDiario) {
                if (valor > 0) {
                    total += valor;
                    contador++;
                }
            }
            double media = total / contador;

            //Calcula o número de dias em que o faturamento foi maior que a média
            int diasAcimaDaMedia = 0;
            for (double valor : faturamentoDiario) {
                if (valor > media) {
                    diasAcimaDaMedia++;
                }
            }

            //Imprime os resultados
            System.out.println("Menor valor de faturamento diário: " + min);
            System.out.println("Maior valor de faturamento diário: " + max);
            System.out.println("Média de faturamento mensal: " + media);
            System.out.println("Número de dias acima da média: " + diasAcimaDaMedia);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}