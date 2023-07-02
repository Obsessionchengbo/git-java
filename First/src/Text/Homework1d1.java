package Text;

public class Homework1d1 {
    public static void main(String[] args) {
        final double BORN_NUMBER = 1.0 / 7;       //一秒有多少人诞生
        final double DEAD_NUMBER = 1.0 / 13;      //一秒有多少人死亡
        final double IMMIGRANT_NUMBER = 1.0 / 45; //一秒有多少新移民
        final int SECONDS_IN_A_YEAR = 365 * 24 * 60 * 60; //一年有多少秒

        int PopulationNumberNow = 312032486;
        int FirstYearPopulation =(int)(PopulationNumberNow + SECONDS_IN_A_YEAR * BORN_NUMBER
                - SECONDS_IN_A_YEAR * DEAD_NUMBER + SECONDS_IN_A_YEAR * IMMIGRANT_NUMBER);
        int SecondYearPopulation = (int)(FirstYearPopulation + SECONDS_IN_A_YEAR * BORN_NUMBER
                - SECONDS_IN_A_YEAR * DEAD_NUMBER + SECONDS_IN_A_YEAR * IMMIGRANT_NUMBER);
        int ThirdYearPopulation = (int)(SecondYearPopulation + SECONDS_IN_A_YEAR * BORN_NUMBER
                - SECONDS_IN_A_YEAR * DEAD_NUMBER + SECONDS_IN_A_YEAR * IMMIGRANT_NUMBER);
        int FourthYearPopulation = (int)(ThirdYearPopulation + SECONDS_IN_A_YEAR * BORN_NUMBER
                - SECONDS_IN_A_YEAR * DEAD_NUMBER + SECONDS_IN_A_YEAR * IMMIGRANT_NUMBER);
        int FifthYearPopulation = (int)(FourthYearPopulation + SECONDS_IN_A_YEAR * BORN_NUMBER
                - SECONDS_IN_A_YEAR * DEAD_NUMBER + SECONDS_IN_A_YEAR * IMMIGRANT_NUMBER);


    System.out.println("The population number of USA in first year : " + FirstYearPopulation);
    System.out.println("The population number of USA in second year : " + SecondYearPopulation);
    System.out.println("The population number of USA in third year : " + ThirdYearPopulation);
    System.out.println("The population number of USA in fourth year : " + FourthYearPopulation);
    System.out.println("The population number of USA in fifth year : " + FifthYearPopulation);
    }
}
