package br.com.conversor.moeda;

import br.com.conversor.recordacao.ValorMoeda;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Moeda {
    private HttpClient client ;
    private Gson gson = new Gson();

    public Moeda(){
        client = HttpClient.newHttpClient();
    }

    public ValorMoeda tipoMoeda(String tipoMoeda){
        HttpRequest  request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/c32d8e001b7deb19e64c9b67/latest/"+tipoMoeda))
                .build();
        try {
          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
          return new Gson().fromJson(response.body(), ValorMoeda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void dolarParaPesoArgentino(String moeda,double quantidade){
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("ARS");
        System.out.printf("%.2f Dolares são %.2f Pesos Argentinos.",quantidade,valor);
    }
    public void PesoArgentinoParadolar(String moeda,double quantidade){
        System.out.println(tipoMoeda(moeda));
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("USD");
        System.out.printf("%.2f Pesos Argentinos são %.4f Dolares.",quantidade,valor);
    }
    public void DolarParaReal(String moeda,double quantidade){
        System.out.println(tipoMoeda(moeda));
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("BRL");
        System.out.printf("%.2f Dolares são %.2f Reais.",quantidade,valor);
    }
    public void RealParaDolar(String moeda,double quantidade){
        System.out.println(tipoMoeda(moeda));
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("USD");
        System.out.printf("%.2f Reais são %.2f Dolares.",quantidade,valor);
    }
    public void DolarParaPesoComlombiano(String moeda,double quantidade){
        System.out.println(tipoMoeda(moeda));
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("COP");
        System.out.printf("%.2f Dolares são %.2f Pesos Comlombianos.",quantidade,valor);
    }
    public void PesoComlombianoParaDolar(String moeda,double quantidade){
        System.out.println(tipoMoeda(moeda));
        double valor = quantidade * tipoMoeda(moeda).conversion_rates().get("USD");
        System.out.printf("%.2f Pesos Comlombianos são %.2f Dolares.",quantidade,valor);
    }






}
