package base;

public class AnonymousClass {
    public static void main(String[] args) {
        class HelloWorld {
            protected String name;
            HelloWorld(String name) {
                this.name = name;
                System.out.println("hello " + name);
            }
        }
        HelloWorld helloWord = new HelloWorld("zhang yong"){
            private String getName() {
                class Name{
                    Name(String name) {
                        System.out.println(name);
                    }
                }
                return name;
            }
            private HelloWorld instance() {
                return this;
            }
        }.instance();
        System.out.println(helloWord);
    }
}
