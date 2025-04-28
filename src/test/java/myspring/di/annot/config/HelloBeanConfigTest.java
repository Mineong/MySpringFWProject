package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import myspring.di.annot.PrinterBean;
import myspring.di.xml.Printer;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
	
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	@Qualifier("")
	PrinterBean printer;
	
	@Test
	void helloBean() {
		assertEquals("hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("hello 어노테이션", printer.toString());
	}

}
