package lesson17;


public class ValidateAddr {
    public static void main(String[] args) {
        String test = "http://dk1.net";
        System.out.println(validate(test));

    }

    private static boolean validate(String address) {
        if (address == null || address.length() <= 2) // перевірка на нул і <=2
            return false;
        String[] domens = new String[]{".com", ".org", ".net"};  // масив з доменів
        if (checkAddressOnWhiteSpace(address))      // перевірка на пробіли
            return false;
        if (!checkName(address))    // перевірка імені
            return false;
        if (!checkDomen(address, domens))   // перевірка домена
            return false;

        return true;
    }

    private static boolean checkName(String address) {   // перевірка ім"я адреси 1 і 2 домена
        if (address.substring(0, 7).equals("http://")) {
            if (address.length() <= 11) return false;
            char[] chars = address.substring(7, address.length() - 4).toCharArray();
            for (char ch : chars) {
                if (!Character.isLetterOrDigit(ch))
                    return false;

            }
        }
        if (address.substring(0, 8).equals("https://") && address.length() >= 12) {
            if (address.length() <= 12) return false;
            char[] chars = address.substring(8, address.length() - 4).toCharArray();
            for (char ch : chars) {
                if (!Character.isLetterOrDigit(ch))
                    return false;

            }
        }
        return true;
    }
    private static boolean checkAddressOnWhiteSpace(String address) {  // перевірка на пробіл
        String[] simbols = address.split("");
        if (simbols.length > 2) {
            for (String simb : simbols) {
                if (Character.isWhitespace(simb.charAt(0)))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkDomen(String address, String[] domens) {    // перевірка домена
        for (String domen : domens) {
            if (address.substring(address.length() - 4, address.length()).equals(domen)) {
                return true;
            }
        }
        return false;
    }

}