// Q6. Library System Assignment:
// Task: Develop a Java program for a library system incorporating encapsulation, abstraction, 
// and inheritance.
// i. LibraryResource Class:
//  - Abstract class with private attributes for title and author.
//  - Constructor, getters, setters, and an abstract method displayDetails().
// ii. Book Class:
//  - Subclass of LibraryResource with additional attribute pageCount.
//  - Constructor, getters, setters, and displayDetails() method override.
// iii. Magazine Class:
//  - Subclass of LibraryResource with additional attribute issueDate.
//  - Constructor, getters, setters, and displayDetails() method override.
// iv. DVD Class:
//  - Subclass of LibraryResource with additional attribute duration.
//  - Constructor, getters, setters, and displayDetails() method override.
// v. LibrarySystem Class (Main):
//  - Instantiate various library resources (e.g., Book, Magazine, DVD).
//  - Call displayDetails() for each instance to show resource information.

abstract class LibraryResource {
    private String title;
    private String author;

    public LibraryResource(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    abstract public void displayDetails();
}

class Book extends LibraryResource {
    private int pageCount;

    public Book(String title, String author, int pageCount) {
        super(title, author);
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void displayDetails() {
        System.out.println("Book Title:" + getTitle());
        System.out.println("Book Author:" + getAuthor());
        System.out.println("Page Count:" + pageCount);
    }
}

class Magazine extends LibraryResource {
    private String issueDate;

    public Magazine(String title, String author, String issueDate) {
        super(title, author);
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void displayDetails() {
        System.out.println("Book Title:" + getTitle());
        System.out.println("Book Author:" + getAuthor());
        System.out.println("Issue Date:" + issueDate);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {
        LibraryResource book = new Book("CSW-2", "xyz", 700);
        LibraryResource magazine = new Magazine("cs", "abc", "Jan 2024");
        book.displayDetails();
        magazine.displayDetails();
    }
}
// Book Author:xyz
// Page Count:700
// Book Title:cs
// Book Author:abc
// Issue Date:Jan 2024
