package pattern;

class DependentObject1 {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class DependentObject2 {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class CoarseGrainedObject {
    DependentObject1 object1 = new DependentObject1();
    DependentObject2 object2 = new DependentObject2();

    public void setData(String data1, String data2) {
        this.object1.setData(data1);
        this.object2.setData(data2);
    }

    public String[] getData() {
        return new String[]{object1.getData(),object2.getData()};
    }
}

class CompositeEntity {
    private CoarseGrainedObject grainedObject = new CoarseGrainedObject();
    public void setData(String data1, String data2) {
        grainedObject.setData(data1,data2);
    }
    public String[] getData() {
        return grainedObject.getData();
    }
}

class CompositeClient {
    private CompositeEntity entity = new CompositeEntity();

    public void printData() {
        for(String data : entity.getData()) {
            System.out.println("Data: " + data);
        }
    }

    public void setData(String data1, String data2) {
        entity.setData(data1,data2);
    }
}

public class CompositeEntityPattern {
    public static void main(String[] args) {
        CompositeClient client = new CompositeClient();
        client.setData("name","age");
        client.printData();
        client.setData("test","second");
        client.printData();
    }
}
