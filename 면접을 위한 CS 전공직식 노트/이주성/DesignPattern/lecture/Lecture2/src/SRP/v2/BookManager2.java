package SRP.v2;

import java.util.List;

public class BookManager2 {
	private List<Book2> books = null;
	private BookDataLoader2 loader = null;
	private BookDataViewer2 viewer = null;
	
	public BookManager2() {
		this(null);
	}
	
	public BookManager2(List<Book2> books) {
		this.books = books;
	}

	public BookDataLoader2 getLoader() {
		return loader;
	}

	public void setLoader(BookDataLoader2 loader) {
		this.loader = loader;
	}

	public BookDataViewer2 getViewer() {
		return viewer;
	}

	public void setViewer(BookDataViewer2 viewer) {
		this.viewer = viewer;
	}

	public void load() {
		books = this.loader.load();
	}	

	public void show() {
		this.viewer.show(books);
	}
}
