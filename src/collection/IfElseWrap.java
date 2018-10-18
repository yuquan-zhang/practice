package collection;

enum Condition{
    LIKE,EQ,NEQ
}

class Query {
    private StringBuilder where;

    Query() {
        where = new StringBuilder();
    }

    void addCondition(Condition condition, String key, String value) {
        if(key == null || value == null) return;
        where.append(key);
        switch (condition) {
            case EQ:
                where.append("=\"").append(value).append("\"");
                break;
            case NEQ:
                where.append("<>\"").append(value).append("\"");
                break;
            case LIKE:
                where.append(" like \"%").append(value).append("%\"");
                break;
                default:break;
        }
        if(where.length() > 0) where.append(" and ");
    }

    @Override
    public String toString() {
        return where.length() == 0 ? "" : where.substring(0, where.length() - 5);
    }
}

public class IfElseWrap {
    public static void main(String[] args) {
        Query query = new Query();
        query.addCondition(Condition.EQ, "name", "Zhang Yong");
        query.addCondition(Condition.NEQ, "sex", "female");
        query.addCondition(Condition.LIKE, "address", "上海");
        query.addCondition(Condition.LIKE, "area", "浦东");
        System.out.printf("the query string is %s%n", query);
    }
}
