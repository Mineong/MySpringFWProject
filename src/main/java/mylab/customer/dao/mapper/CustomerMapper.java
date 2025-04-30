package mylab.customer.dao.mapper;

import java.util.List;
import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {

    // id로 고객 조회
    CustomerVO selectCustomer(int id);

    // 전체 고객 조회
    List<CustomerVO> selectAllCustomer();

    // 고객 등록
    void insertCustomer(CustomerVO customer);
}
