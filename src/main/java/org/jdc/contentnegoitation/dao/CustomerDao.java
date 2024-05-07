package org.jdc.contentnegoitation.dao;

import org.jdc.contentnegoitation.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

}
