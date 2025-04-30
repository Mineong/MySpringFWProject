package mylab.customer;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-beans-mybatis.xml"})
public class CustomerSpringTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testInsertAndSelect() {
       
        CustomerVO customer = new CustomerVO();
        customer.setEmail("test2@example.com");
        customer.setName("test");
        customer.setAge(25);
        customerService.insertCustomer(customer);

        List<CustomerVO> list = customerService.getAllCustomerList();
        for (CustomerVO vo : list) {
            System.out.println(vo);
        }

        CustomerVO one = customerService.getCustomerInfo(1);
        System.out.println("ID=1인 고객 정보: " + one);
    }
}
