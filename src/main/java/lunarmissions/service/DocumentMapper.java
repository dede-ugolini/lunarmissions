package lunarmissions.service;

import java.util.Map;

import org.dizitart.no2.collection.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocumentMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Document toDocument(Object obj) {
        Map<String, Object> map = mapper.convertValue(obj, Map.class);
        return Document.createDocument(map);
    }

    public static <T> T toObject(Document doc, Class<T> clazz) {
        return mapper.convertValue(doc, clazz);
    }
}
