package uz.learn.catalogapi.repository;

import java.util.List;

import org.bson.types.ObjectId;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import uz.learn.catalogapi.entity.Product;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public Uni<List<Product>> getProducts() {
		return findAll().list();
	}

	@Override
	public Uni<List<Product>> getProductsByCategory(String category) {
		return find("category", category)
				.list();
	}

	@Override
	public Uni<Product> getById(String id) {
		return findById(new ObjectId(id));
	}

	@Override
	public Uni<Boolean> deleteById(String id) {
		return deleteById(new ObjectId(id));
	}
}
