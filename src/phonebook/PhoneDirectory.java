package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory  {
    private final List<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for(Record record: records) {
            if(record.getName().equalsIgnoreCase(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                result.add(record);
            }
        }
        return result;

    }







}
