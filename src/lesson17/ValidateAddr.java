package lesson17;


public class ValidateAddr {
    public static void main(String[] args) {
        String test = "http://1.com";
        System.out.println(validate(test));

    }

    private static boolean validate(String address) {
        if (address == null)  // перевірка адреси на null
            return false;
        String[] domens = new String[]{".com", ".org", ".net"};  // створюю масив з назвами доменів
        if (address.length() >= 12 // мінімально можлива довжина адреса
                && checkAddressOnWhiteSpace(address) // перевірка на пробіли
                && address.substring(0, 7).equals("http://")  // прирівнюю до протоколу
                && checkWord(address.substring(8, address.length() - 4)) // перевіряю назву адреси

                || address.length() >= 13   // аналогічно з другим протоколом https://
                && checkAddressOnWhiteSpace(address)
                && (address.substring(0, 8).equals("https://"))
                && checkWord(address.substring(9, address.length() - 4))) {
                                                                                 // якщо тру, то перевіряємо домен
            for (String domen : domens) {
                if (address.substring(address.length() - 4, address.length()).equals(domen)) { // прирівнюємо домен адреси до доступних доменів
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkWord(String word) {   // перевірка символів на букву і цифру
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }
        return true;
    }

    private static boolean checkAddressOnWhiteSpace(String address) {   //метод перевіряє на вайтспейс і чи масив з стрінгів менший за 2
        String[] simbols = address.split("");
        if (simbols.length > 2) {
            for (String simb : simbols) {
                if (Character.isWhitespace(simb.charAt(0)))
                    return false;
            }
        }
        return true;
    }
}