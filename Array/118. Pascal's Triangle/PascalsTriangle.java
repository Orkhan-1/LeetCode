import java.util.ArrayList;
import java.util.List;

//        Java
// Time complexity -  O (N2)
// Space complexity - O (N2)
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> prevRow = triangle.get(rowNum - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}
