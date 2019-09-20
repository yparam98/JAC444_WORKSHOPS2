package task1;

public class validatorFunctions
{
    public static String cardType = "";

    // method for validating a credit card number; utilizes other methods in class
    public static boolean isValid(long number)
    {
        boolean valid = false;
        if (getSize(number) >= 13 && getSize(number) <= 16)
        {
            if (prefixMatched(number,4)||prefixMatched(number,5)||prefixMatched(number,37)||prefixMatched(number,6))
            {
                if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number))%10 == 0)
                {
                    valid = true;
                }
            }
        }
        return valid;
    }

    // sum of doubled digits from right to left
    public static int sumOfDoubleEvenPlace(long number)
    {
        String numberStr = Long.toString(number);
        int sum = 0;

        for (int index = numberStr.length()-2; index >= 0; index = index - 2)
        {
            String temp = "";
            temp = Integer.toString((Character.getNumericValue(numberStr.charAt(index))*2));
            sum += getDigit(Integer.parseInt(temp));
        }
        return sum;
    }

    // if 2 digits ? return sum : return digit
    public static int getDigit(int number)
    {
        String numberStr = Integer.toString(number);
        int c = 0;
        if (numberStr.length() == 2)
        {
            int a = Character.getNumericValue(numberStr.charAt(0));
            int b = Character.getNumericValue(numberStr.charAt(1));
            c = a+b;
        }
        else
        {
            c = Integer.parseInt(numberStr);
        }
        return c;
    }

    // returns sum of summed digits
    public static int sumOfOddPlace(long number)
    {
        String numberStr = Long.toString(number);
        int sum = 0;
        for (int index = numberStr.length()-1; index >= 0; index = index - 2)
        {
            sum += Character.getNumericValue(numberStr.charAt(index));
        }
        return sum;
    }

    // if prefix matches the incoming prefix? return true : false otherwise
    public static boolean prefixMatched(long number, int d)
    {
        boolean matched = false;

        String numberStr = Long.toString(d);
        long prefix = getPrefix(number, numberStr.length());

        if (d == prefix)
        {
            matched = true;

            if (prefix == 4)
            {
                cardType = "visa";
            }
            else if (prefix == 5)
            {
                cardType = "mastercard";
            }
            else if (prefix == 6)
            {
                cardType = "discover";
            }
            else
            {
                cardType = "amex";
            }
        }

        return matched;
    }

    // get the length (# of digits) of the incoming number
    public static int getSize(long d)
    {
        String numberStr = Long.toString(d);
        return numberStr.length();
    }

    // gets the prefix of the incoming number
    public static long getPrefix(long number, int k)
    {
        long prefix = 0;
        String numberStr = Long.toString(number);
        prefix = Long.parseLong(numberStr.substring(0,k));

        return prefix;
    }
}