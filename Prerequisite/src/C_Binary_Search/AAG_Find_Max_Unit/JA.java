package C_Binary_Search.AAG_Find_Max_Unit;

import java.util.List;

public class JA {
    private int findMaximumAlloyUnits(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget){
        int unit = 1;
        boolean loop = true;

        while(loop){
            int sum = 0;
            for(int i=0 ; i<composition.size() ; i++){
                int comp = composition.get(i) * unit;
                int need = comp - stock.get(i);

                if(need < 0) need = 0;
                sum += need * cost.get(i);
            }

            if(sum < budget) unit++;
            else loop = false;
        }

        return unit;
    }
}
