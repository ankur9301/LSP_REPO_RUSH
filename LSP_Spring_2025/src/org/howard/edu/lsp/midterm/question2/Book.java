// Book.java
package org.howard.edu.lsp.midterm.question2;

/**
 * The Book class represents a book in a library.
 * It encapsulates the book's title, author, ISBN, and the year it was published.
 */
public class Book {
    // Private fields for encapsulation
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructs a new Book with the specified details.
     *
     * @param title         the title of the book
     * @param author        the author of the book
     * @param ISBN          the unique ISBN of the book
     * @param yearPublished the year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the book's ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param ISBN the new ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Returns the year the book was published.
     *
     * @return the year published
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     *
     * @param yearPublished the new publication year
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Compares this Book to the specified object.
     * Two books are considered equal if they have the same ISBN and author.
     *
     * @param obj the object to compare with
     * @return true if the books are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the same reference
        if (this == obj) {
            return true;
        }
        // Check for null and ensure the object is a Book
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return this.ISBN.equals(other.ISBN) && this.author.equals(other.author);
    }

    /**
     * Returns a string representation of the Book.
     *
     * @return a formatted string containing the book's details
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +
               ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
