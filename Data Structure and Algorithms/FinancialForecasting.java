public class FinancialForecasting {
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }
    private static double[] memo;
    public static double futureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1) * (1 + growthRate);
        return memo[years];
    }
    public static void main(String[] args) {
        double presentValue = 1000, growthRate = 0.05; int years = 5;
        System.out.printf("Recursive: %.2f%n", futureValue(presentValue, growthRate, years));
        memo = new double[years+1];
        System.out.printf("Memoized: %.2f%n", futureValueMemo(presentValue, growthRate, years));
    }
}
