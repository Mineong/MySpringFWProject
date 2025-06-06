package mylab.book.entity;

public class Publication {
    private String title;
    private String publishDate;
    private int page;
    private int price;

    public Publication() {}

    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getPublishDate() { return publishDate; }
    public int getPage() { return page; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() { return title; }
}