package base;

import java.util.Arrays;

public class CharSequenceImpl  implements CharSequence{
    private char[] chars;

    CharSequenceImpl(String charString) {
        chars = charString.toCharArray();
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        return chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        char[] subCharArray = Arrays.copyOfRange(chars,start,end);
        return new CharSequenceImpl(String.copyValueOf(subCharArray));
    }

    @Override
    public String toString() {
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        CharSequence charSequence = new CharSequenceImpl("this is a char sequence test");
        System.out.println(charSequence.length());
        System.out.println(charSequence.charAt(6));
        System.out.println(charSequence.subSequence(3,8));
        System.out.println(charSequence);
    }
}
