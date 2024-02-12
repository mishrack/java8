package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                         new Apple("green", 200),
                         new Apple("green", 100),
                         new Apple("red", 220),
                         new Apple("green", 250)
        );

        /*
         * Passing methods as values , known as Method Reference
         * In this approach we have to write methods then pass them as arguments
         */
        List<Apple> greenApples = filterApple(apples,FilteringApples::isAppleGreen);
        System.out.println(greenApples);
        List<Apple> bigSizeApples = filterApple(apples,FilteringApples::isAppleSizeBig);
        System.out.println(bigSizeApples);

        /*
        * Using Lambdas instead of method references
        * In this approach we don't have to write method definitions , isAppleGreen/isAppleSizeBig
        */
        List<Apple> applesList = filterApple(apples, (Apple a) -> a.getColour().equalsIgnoreCase("green"));
        System.out.println("green apples : " + applesList);
        List<Apple> bigApples = filterApple(apples , (Apple a) -> a.getWeight() > 150) ;
        System.out.println("bigApples : " + bigApples);
        List<Apple> greenAndBigApple = filterApple(apples,(Apple a) -> a.getColour().equalsIgnoreCase("green") && a.getWeight() > 150);
        System.out.println("greenAndBigApple : " + greenAndBigApple);
    }

    public static boolean isAppleGreen(Apple apple){
        return apple.getColour().equalsIgnoreCase("green");
    }
    public static boolean isAppleSizeBig(Apple apple){
        return  apple.getWeight()> 150;
    }
    // filter apples
    static List<Apple> filterApple(List<Apple> inventory,Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return  result ;
    }

    public static class Apple{
        private String colour = "" ;
        private int weightInGram = 0;

        public Apple(String colour, int weight) {
            this.colour = colour;
            this.weightInGram = weight;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public int getWeight() {
            return weightInGram;
        }

        public void setWeight(int weight) {
            this.weightInGram = weight;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Apple{");
            sb.append("colour='").append(colour).append('\'');
            sb.append(", weightInGram=").append(weightInGram);
            sb.append('}');
            return sb.toString();
        }
    }

}
