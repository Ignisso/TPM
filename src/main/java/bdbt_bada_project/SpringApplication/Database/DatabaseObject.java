package bdbt_bada_project.SpringApplication.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DatabaseObject {
    protected List<Object> field = new ArrayList<>();
    protected Map<Integer, String> fieldNames = new HashMap();
    protected String tableName;

    protected Integer toFieldIndex(String fieldname) {
        for (Map.Entry<Integer, String> entry: fieldNames.entrySet()) {
            if (fieldname.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Object parse(Object obj) {
        if (obj == null)
            return("NULL");
        if (obj.getClass().getSimpleName().equals("String"))
            return("'" + obj + "'");
        if (obj.getClass().getSimpleName().equals("Character"))
            return("'" + obj + "'");
        return obj;
    }

    public DatabaseObject(String tableName) {
        this.tableName = tableName;
    }

    public Integer getFieldsNumber() {
        return field.size();
    }

    public String getFieldName(Integer index) {
        return(fieldNames.get(index));
    }

    public Object getField(Integer index) {
        return(parse(field.get(index)));
    }

    public Object getField(String fieldname) {
        return(getField(toFieldIndex(fieldname)));
    }

    public void updateField(Integer index, Object value) {
        field.set(index, value);
    }

    public void updateField(String fieldname, Object value) {
        updateField(toFieldIndex(fieldname), value);
    }

    String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "{");
        for (int i = 0; i < getFieldsNumber(); i++) {
            sb.append("[" + i + "] " + fieldNames.get(i) + "=" + field.get(i) + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }
}
