package Local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Veiculo{
    Map<String, List<String>> info = new HashMap<>();
    

    public  void addVec(String placa, String type, String hours){
          addCar(placa, type, hours);
    }


    public  void remVec(String Placa){
        remCar(Placa);
    }
    
    private void addCar(String Placa, String Type, String hours){
    List<String> novaLista = new ArrayList<>();
    novaLista.add(Type);  
    novaLista.add(hours); 
    info.put(Placa, novaLista);
}

private void remCar(String Placa){
    info.remove(Placa);
   
}

public String getType(String placa) {
    if (info.containsKey(placa)) {
        List<String> dados = info.get(placa);
        return dados.get(0); 
    }
    return "Placa não encontrada";
}
   public String getHours(String placa) {
        if (info.containsKey(placa)) {
            return info.get(placa).get(1);
        }
        return null;
    }


}

