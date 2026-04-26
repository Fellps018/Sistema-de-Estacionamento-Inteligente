package Local;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Estacionamento {
    ArrayList<Integer> cars = new ArrayList<Integer>();

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
    Veiculo veiculo = new Veiculo();

    int vagasTotais = 10;

    //Entrada de Veiculos
    public void entrada(String placa,String type){
      LocalTime agora = LocalTime.now();
      String hours = agora.format(formatador);

      boolean eTipoValidoCar = "Carro".equals(type) || "Moto".equals(type);
      boolean eTipoValidoCaminhao = "Caminhão".equals(type);
      boolean veiculoNaoRegistrado = veiculo.info.containsKey(placa);

   if (quantidadeVagas() < vagasTotais && eTipoValidoCar && !veiculoNaoRegistrado){
            entradaCar();
            veiculo.addVec(placa, type, hours);
            msn(placa, hours);
         }
         else if(quantidadeVagas() + 2 <= vagasTotais && eTipoValidoCaminhao && !veiculoNaoRegistrado){
            entradaCaminhao();
            veiculo.addVec(placa, type, hours);
             msn(placa, hours);
         }else{
            System.out.println("Houve um erro, tente novamente.");
         }
    }
   /////////////////
    
   //Saída de Veiculos
   public void saida(String placa){
         if(!veiculo.info.containsKey(placa)){
            System.out.println("Veiculo não encontrado");
         }else if(veiculo.getType(placa).equals("Carro") || veiculo.getType(placa).equals("Moto")){
            saidaCar();
            pagamento(placa);
            veiculo.remVec(placa);
            System.out.println("Saída com sucesso.");
         }else if(veiculo.getType(placa).equals("Caminhão")){
            saidaCaminhao();
            pagamento(placa);
            veiculo.remVec(placa);
             System.out.println("Saída com sucesso.");
         }else{
            System.out.println("Erro!!!");
         }
   }
///////////////////////

   public int quantidadeVagas(){
    return cars.size();
   }

    public void msn(String placa, String hours){
      System.out.println("|==================================================================================|");
      System.out.println("   Veiculo com a placa: " + placa + " estacionado com sucesso, no horario: " + hours);
      System.out.println("|==================================================================================|");
    }

    public void pagamento(String placa){
      LocalTime inicio = LocalTime.parse(veiculo.getHours(placa));
      LocalTime fim = LocalTime.now();
      String fims = fim.format(formatador);

      long minutosTotais = ChronoUnit.MINUTES.between(inicio, fim);

      double valorPagar = minutosTotais * 5.40;

     System.out.println("   |==================================================================================|");
System.out.printf("   |- Horario da Entrada: %s |- Horario da Retirada: %s\n", veiculo.getHours(placa), fims);
System.out.printf("   |- Tempo Total: %d minutos       |- Total a pagar: R$ %.2f\n", minutosTotais, valorPagar);
System.out.println("   |==================================================================================|");
    }

private void entradaCar(){
       cars.add(1);
}

private void entradaCaminhao(){
       cars.add(1);
       cars.add(1);
}


   private void saidaCar(){
     cars.remove(cars.size() - 1);
}

private void saidaCaminhao(){
      cars.remove(cars.size() - 1);
      cars.remove(cars.size() - 1);
}


}
