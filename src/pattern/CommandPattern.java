package pattern;

interface ActionListenerCommand {
    void execute();
}

class Document {
    public void save() {
        System.out.println("document saved");
    }
    public void open() {
        System.out.println("document opened");
    }
}

class ActionOpen implements ActionListenerCommand {
    private Document document;
    public ActionOpen(Document document) {
        this.document = document;
    }
    public void execute() {
        document.open();
    }
}

class ActionSave implements ActionListenerCommand {
    private Document document;
    public ActionSave(Document document) {
        this.document = document;
    }
    public void execute() {
        document.save();
    }
}

class MenuOptions {
    ActionListenerCommand openAction;
    ActionListenerCommand saveAction;
    public MenuOptions(ActionListenerCommand openAction, ActionListenerCommand saveAction) {
        this.openAction = openAction;
        this.saveAction = saveAction;
    }
    public void clickOpen() {
        openAction.execute();
    }
    public void clickSave() {
        saveAction.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Document document = new Document();
        ActionListenerCommand openAction = new ActionOpen(document);
        ActionListenerCommand saveAction = new ActionSave(document);
        MenuOptions menuOptions = new MenuOptions(openAction,saveAction);
        menuOptions.clickOpen();
        menuOptions.clickSave();
    }
}
