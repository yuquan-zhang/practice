package annotation;

import java.awt.datatransfer.Clipboard;

public class ClipboardDemo {
    public static void main(String[] args) {
        Clipboard clipboard = new Clipboard("clipboardOne");
        System.out.println(clipboard.getName());
        System.out.println(clipboard.getAvailableDataFlavors().length);
    }
}
