package myspring.di.xml.config;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)

public class HelloConfigTest {

	@Autowired
	List<String> namelist;

	@Test
	void helloConfig() {
		for (String name : namelist) {
			System.out.println(name);
			
		}

	}

}