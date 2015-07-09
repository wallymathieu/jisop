package jisop.test;

import jisop.Build;
import jisop.command_line.parse.ParsedArguments;
import jisop.infrastructure.StringUtils;
import jisop.test.fake_controllers.ObjectController;
import jisop.test.helpers.Counter;
import jisop.test.testData.WithTwoFields;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by mathieu.
 */
public class StringFormatterTest {
    @Test
    public void It_can_format_object() {
        Counter count = new Counter();
        Function<Class, Object> factory = (Class t) ->{
            Assert.assertEquals(ObjectController.class, t);
            ObjectController o= new ObjectController();
            o.onAction = () -> count.next();
            return (Object)o;
        };
        ParsedArguments arguments = new Build()
                .recognizeClass(ObjectController.class)
                .setFactory(factory)
                .parse(new String[] { "Object", "Action" });

        Assert.assertEquals(0, arguments.unRecognizedArguments.size());
        String result = StringUtils.join("\n", arguments.invoke());
        Assert.assertEquals("1",
                result);
    }

    @Test
    public void It_can_format_array_of_objects(){
        Counter count = new Counter();
        Function<Class, Object> factory = (Class t) -> {
            Assert.assertEquals(ObjectController.class, t);
            ObjectController o= new ObjectController();
            o.onAction = () -> new Object[]{
                    count.next(),
                    count.next()
            };
            return (Object)o;
        };
        ParsedArguments arguments = new Build()
                .recognizeClass(ObjectController.class)
                .setFactory(factory)
                .parse(new String[]{"Object", "Action"});

        Assert.assertEquals(0, arguments.unRecognizedArguments.size());
        String result = StringUtils.join("\n", arguments.invoke());
        Assert.assertEquals("1\n2",
                result);
    }
    @Test
    public void It_can_format_collection_of_objects(){
        Counter count = new Counter();
        Function<Class, Object> factory = (Class t) -> {
            Assert.assertEquals(ObjectController.class, t);
            ObjectController o= new ObjectController();
            o.onAction = () -> Arrays.asList(new Object[]{
                    count.next(),
                    count.next()
            });
            return (Object)o;
        };
        ParsedArguments arguments = new Build()
                .recognizeClass(ObjectController.class)
                .setFactory(factory)
                .parse(new String[]{"Object", "Action"});

        Assert.assertEquals(0, arguments.unRecognizedArguments.size());
        String result = StringUtils.join("\n", arguments.invoke());
        Assert.assertEquals("1\n2",
                result);
    }
}
