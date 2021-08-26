import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.thoughtworks.xstream.XStream;

public class test{

    public static void main(String[] args) throws Exception {

        Path fileName = Path.of("CommonsCollections7.xml");
        String xml = Files.readString(fileName);
        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }
}