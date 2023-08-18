import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return calculateMinCost(price, special, needs, new HashMap<>());
    }

    private int calculateMinCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }
        int minCost = calculateCost(price, needs);
        for (List<Integer> current : special) {
            if (isSpecialApplicable(needs, current)) {
                List<Integer> updatedNeeds = new ArrayList<>(needs);
                for (int i = 0; i < needs.size(); i++) {
                    updatedNeeds.set(i, updatedNeeds.get(i) - current.get(i));
                }
                int offerCost = current.get(current.size() - 1);
                minCost = Math.min(minCost, offerCost + calculateMinCost(price, special, updatedNeeds, dp));
            }
        }

        dp.put(needs, minCost);
        return minCost;
    }

    private boolean isSpecialApplicable(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }
        }
        return true;
    }

    private int calculateCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }

}
