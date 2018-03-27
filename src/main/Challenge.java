package main;

public class Challenge {

    public static void main(String[] args){
        System.out.print(numberToOrdinal(14));
    }

    public static String numberToOrdinal( Integer number ) {
        if(number == 0){
            return "0";
        }
        if(number.toString().length()>1){
            String lastTwoDigits = number.toString().substring(number.toString().length()-2,number.toString().length());
            if(lastTwoDigits.equalsIgnoreCase("11") ||lastTwoDigits.equalsIgnoreCase("12")
                    ||lastTwoDigits.equalsIgnoreCase("13")){
                return number+"th";
            }
        }

        int maxRemainder = number % 10;

        switch (maxRemainder) {
            case 1:
                return number+"st";
            case 2:
                return number+"nd";
            case 3:
                return number+"rd";
            default:
                return number+"th";
        }
    }
}
