package agreement;

public class CharLength {
    public static void main(String[] args) {
        Character c = 'a';
        System.out.println(Character.BYTES);
        System.out.println(Character.SIZE);
        System.out.println(Integer.BYTES);
        System.out.println(Long.BYTES);
        System.out.println(Integer.toBinaryString(c));
        System.out.println("".split(",").length);
    }
}
