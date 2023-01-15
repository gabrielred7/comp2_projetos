
package intersecao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculadorIntersecaoEsperto extends CalculadorIntersecao{

    @Override
    public int getQuantidadeElementosEmComum(List lista1, List lista2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < lista1.size(); i++) {
            if (map.containsKey(lista1.get(i))) map.put((Integer) lista1.get(i), map.get(lista1.get(i))+1);
            else map.put((Integer) lista1.get(i), 1);
        }
        for (int i = 0; i < lista2.size(); i++) {
            if (map.containsKey(lista2.get(i)) && map.get(lista2.get(i)) > 0) {
                result.add((Integer) lista2.get(i));
                map.put((Integer) lista2.get(i), map.get(lista2.get(i)) -1);
            }
        }
        int cont = 0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < result.size(); i++) {
            r.add(i);
            cont++;
        }
        return cont;
    }
}
