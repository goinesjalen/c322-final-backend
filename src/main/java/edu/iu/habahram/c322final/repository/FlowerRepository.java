package edu.iu.habahram.c322final.repository;

import edu.iu.habahram.c322final.model.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends CrudRepository<Flower, String> {
}
