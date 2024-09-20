package uz.learn.catalogapi.entity;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;

@MongoEntity(database = "catalogDb",
collection = "Products")
public class Product extends ReactivePanacheMongoEntityBase{
    private ObjectId id;
    private String name;
    private String category;
    private String summary;
    private String description;
    private String imageFile;
    private Double price;
	public ObjectId getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public String getSummary() {
		return summary;
	}
	public String getDescription() {
		return description;
	}
	public String getImageFile() {
		return imageFile;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
