package bdbt_bada_project.SpringApplication;

import bdbt_bada_project.SpringApplication.Database.DAO;
import bdbt_bada_project.SpringApplication.Database.DatabaseObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DAOTests {
    private class TestObject extends DatabaseObject {
        public TestObject() {
            super("test_table");
            fieldNames.put(0, "test_integer");
            field.add(0);
            fieldNames.put(1, "test_float");
            field.add(0.f);
            fieldNames.put(2, "test_string");
            field.add("");
            fieldNames.put(3, "test_char");
            field.add('?');
            fieldNames.put(4, "test_other");
            field.add(null);
        }

        public List<Object> getFields() {
            return field;
        }

        public Map<Integer, String> getFieldsNames() {
            return fieldNames;
        }
    }

    private TestObject testobj;
    private DAO<TestObject> daotest;

    @BeforeEach
    void setup() {
        testobj = new TestObject();
        daotest = new DAO<>();
    }

    @Test
    void initTest() {
        assertEquals(testobj.getFields().size(), testobj.getFieldsNames().size());
        assertEquals(5, testobj.getFields().size());
        assertThrows(IndexOutOfBoundsException.class, () -> testobj.getField(5));
        assertThrows(NullPointerException.class, () -> testobj.getField("doesnotexists"));
    }

    @Test
    void selectTest() {
        String sql = "SELECT * FROM test_table WHERE test_integer = 0";
        daotest.select(testobj);
        assertEquals(sql, daotest.getLastSql());
    }

    @Test
    void selectTestModified1() {
        testobj.updateField("test_integer", 2);
        testobj.updateField("test_string", "test");
        String sql = "SELECT * FROM test_table WHERE test_integer = 2";
        daotest.select(testobj);
        assertEquals(sql, daotest.getLastSql());
    }

    @Test
    void selectByFieldsNameTest() {
        testobj.updateField("test_integer", 2);
        testobj.updateField("test_string", "test");
        testobj.updateField("test_float", 2.7f);
        String sql = "SELECT * FROM test_table WHERE test_string = 'test' AND test_float = 2.7";
        daotest.selectByFieldsName(testobj, new String[]{"test_float", "test_string"});
        assertEquals(sql, daotest.getLastSql());
    }

    @Test
    void selectByFieldsNameTest2() {
        testobj.updateField("test_char", 'Y');
        testobj.updateField("test_other", null);
        String sql = "SELECT * FROM test_table WHERE test_other = NULL AND test_char = 'Y'";
        daotest.selectByFieldsName(testobj, new String[]{"test_char", "test_other"});
        assertEquals(sql, daotest.getLastSql());
    }

    @Test
    void selectByFieldsNumberTest() {
        testobj.updateField(0, 2);
        testobj.updateField(2, "test");
        testobj.updateField(1, 2.7f);
        String sql = "SELECT * FROM test_table WHERE test_string = 'test' AND test_float = 2.7";
        daotest.selectByFieldsNumber(testobj, new Integer[]{1, 2});
        assertEquals(sql, daotest.getLastSql());
    }

    @Test
    void selectByFieldsNumberTest2() {
        testobj.updateField(3, 'Y');
        testobj.updateField(4, null);
        String sql = "SELECT * FROM test_table WHERE test_other = NULL AND test_char = 'Y'";
        daotest.selectByFieldsNumber(testobj, new Integer[]{3, 4});
        assertEquals(sql, daotest.getLastSql());
    }
}
