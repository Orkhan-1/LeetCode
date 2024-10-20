import java.util.HashMap;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] result = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(1);

            Map<String, Double> conversion;
            if (map.containsKey(first)) {
                conversion = map.get(first);
            } else {
                conversion = new HashMap<>();
            }
            conversion.put(second, values[i]);
            map.put(first, conversion);

            Map<String, Double> reverseConversion;
            if (map.containsKey(second)) {
                reverseConversion = map.get(second);
            } else {
                reverseConversion = new HashMap<>();
            }
            reverseConversion.put(first, 1 / values[i]);
            map.put(second, reverseConversion);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String input = query.get(0);
            String output = query.get(1);
            double finalValue = 1.0;
            Set<String> cache = new HashSet<>();
            cache.add(input);
            double conversionResult = dfs(cache, input, output, finalValue, map);
            result[i] = conversionResult;
        }

        return result;
    }

    private double dfs(Set<String> cache, String input, String output, double finalValue, Map<String, Map<String, Double>> map) {
        Map<String, Double> conversions = map.get(input);

        if (input.equals(output) && map.containsKey(input) && map.containsKey(output)) {
            return finalValue;
        }

        if (conversions != null) {
            for (Map.Entry<String, Double> conversion : conversions.entrySet()) {

                if (!cache.contains(conversion.getKey())) {
                    cache.add(conversion.getKey());
                    double result = dfs(cache, conversion.getKey(), output, conversion.getValue() * finalValue, map);
                    if (result != -1.0) {
                        return result;
                    }
                }
            }
        }

        return -1.0;
    }

}