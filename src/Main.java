import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vipin Samleti
 */
public class Main {

    static long calculateMinimumCost(List<Integer> costList)
    {

        int costListSize = costList.size();
        long totalCalculatedCost = 0;

        Collections.sort(costList);

        for (int i = costListSize - 1; i > 1; i -= 2) {
            if (i == 2)
                totalCalculatedCost += costList.get(2)  + costList.get(0);
            else {
                long price_first = costList.get(i) + costList.get(0)  + 2 * costList.get(1);
                long price_second = costList.get(i) + costList.get(i - 1)  + 2 * costList.get(0);
                totalCalculatedCost += Math.min(price_first, price_second);
            }
        }

        if (costListSize == 1)
            totalCalculatedCost = totalCalculatedCost + costList.get(0);
        else
            totalCalculatedCost = totalCalculatedCost + costList.get(1);

        return totalCalculatedCost;
    }


    public static void main (String cp[])
    {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of test case you want to test: ");
            int numberOfTestCases = scanner.nextInt();

            List<List<Integer>> listOfCostList = new ArrayList<>();
            for (int i = 0; i < numberOfTestCases; i++) {

                System.out.println("Enter number of person: ");
                int numberOfPerson = scanner.nextInt();

                System.out.println("Enter cost of ith person by space separated: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String cost = reader.readLine();

                List<Integer> costList = Arrays.asList(cost.split(" ")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
                listOfCostList.add(costList);
            }

            List<Long> totalCostList = new ArrayList<>();
            listOfCostList.forEach(costList -> totalCostList.add(calculateMinimumCost(costList)) );

            System.out.println("\n\nCalculated minimum cost for each task :: ");
            totalCostList.forEach(totalCost -> System.out.println(totalCost));

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
