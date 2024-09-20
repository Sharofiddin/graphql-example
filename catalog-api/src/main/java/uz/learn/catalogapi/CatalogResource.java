package uz.learn.catalogapi;

import java.util.List;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uz.learn.catalogapi.entity.Product;
import uz.learn.catalogapi.repository.ProductRepository;

@Path("/api/v1/products")
public class CatalogResource {
   private final ProductRepository repo;
   
   public CatalogResource(ProductRepository productRepository) {
	   this.repo = productRepository;
   }
   
   @GET
   public Uni<List<Product>> getProducts(){
	   return repo.getProducts();
   }
   
   @GET
   @Path("/category/{category}")
   public Uni<List<Product>> getProductsByCategory(@PathParam("category")  String category){
	   return repo.getProductsByCategory(category);
   }
   
   @GET
   @Path("/{id}")
   public Uni<Product> getProductsById(@PathParam("id")  String id){
	   return repo.getById(id);
   }
}
