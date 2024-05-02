package edu.iu.habahram.c322final.repository;

import edu.iu.habahram.c322final.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
}
