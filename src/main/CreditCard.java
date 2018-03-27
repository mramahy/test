package main;

public class CreditCard {

    public static void main(String[] args){

    }

    public static String maskify(String creditCardNumber) {
        if(creditCardNumber.isEmpty()){
            return creditCardNumber;
        }
        // Add code here
        char[] sequence = creditCardNumber.toCharArray();
        StringBuffer maskedCreditCardNumber = new StringBuffer();
        for(int i=0;i<sequence.length-4;i++){
            if(i == 0){
                maskedCreditCardNumber.append(sequence[i]);
            }else if((Character.toString(sequence[i]).matches("\\d"))){
                maskedCreditCardNumber.append("#");
            }else{
                maskedCreditCardNumber.append(sequence[i]);
            }
        }
        maskedCreditCardNumber.append(creditCardNumber.substring(creditCardNumber.length()-4, creditCardNumber.length()));
        return maskedCreditCardNumber.toString();
    }
}
