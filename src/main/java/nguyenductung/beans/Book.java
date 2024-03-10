package nguyenductung.beans;

public class Book {
	private String bookId;
	private String title;
	private String author;
	private Integer release;
	private Float price;
	private String picture;
	private Integer publisherId;
	private Integer categoryId;
	private String publisherName;
	private String categoryName;
	
	public Book() {}
	
	public Book(String bookId, String title, String author, Integer release, Float price, String picture,
			Integer publisherId, Integer categoryId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.release = release;
		this.price = price;
		this.picture = picture;
		this.publisherId = publisherId;
		this.categoryId = categoryId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRelease() {
		return release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
