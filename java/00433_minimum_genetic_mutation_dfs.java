import java.util.HashSet;
import java.util.Set;


public class SolutionDFS {

    private Set<String> mutations = new HashSet<>();
    private int minMutation = 0;

    public int minMutation(String startGene, String endGene, String[] bank) {

        for (int i = 0; i < bank.length; i++) {
            mutations.add(bank[i]);
        }

        if (!mutations.contains(endGene)) {
            return -1;
        }
        findMinMutation(startGene, endGene, 0);
        return minMutation > 0 ? minMutation : -1;
    }

    private void findMinMutation(String startGene, String endGene, int mutationNumber) {

        if (startGene.equals(endGene)) {
            if (minMutation == 0) {
                minMutation = mutationNumber;
            } else {
                minMutation = Math.min(mutationNumber, minMutation);
            }
            return;
        }

        for (String mutation : new HashSet<>(mutations)) {
            int error = 0;
            for (int i = 0; i < mutation.length(); i++) {
                if (mutation.charAt(i) != startGene.charAt(i)) {
                    error++;
                    if (error > 1) break;
                }
            }

            if (error == 1) {
                mutations.remove(mutation);
                findMinMutation(mutation, endGene, mutationNumber + 1);
                mutations.add(mutation);
            }
        }
    }
}
