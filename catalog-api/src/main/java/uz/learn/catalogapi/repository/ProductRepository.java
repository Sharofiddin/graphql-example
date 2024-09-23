package uz.learn.catalogapi.repository;

import java.util.List;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import uz.learn.catalogapi.entity.Product;

public interface ProductRepository extends ReactivePanacheMongoRepository<Product> {
	Uni<List<Product>> getProducts();

	Uni<List<Product>> getProductsByCategory(String category);

	Uni<Product> getById(String id);
	Uni<Boolean> deleteById(String id);
}
