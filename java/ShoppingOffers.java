import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return calculateMinCost(price, special, needs, new HashMap());
    }

    private int calculateMinCost(List<Integer> price, List<List<Integer>> specials, List<Integer> needs, Map<List<Integer>, Integer> dp) {

        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }

        int cost = calculateCost(price, needs);

        for (List<Integer> special : specials) {
            if (isSpecialApplicable(special, needs)) {
                List<Integer> updatedNeeds = new ArrayList(needs);
                for (int i = 0; i < needs.size(); i++) {
                    updatedNeeds.set(i, needs.get(i) - special.get(i));
                }
                int offerCost = special.get(special.size() - 1);
                cost = Math.min(cost, offerCost + calculateMinCost(price, specials, updatedNeeds, dp));
            }
        }
        dp.put(needs, cost);
        return cost;
    }

    private int calculateCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        return cost;
    }

    private boolean isSpecialApplicable(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (special.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

}
