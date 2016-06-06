package shaurya.assignment_aftertax;

/**
 * Created by Ishan Shaurya Jaiswal.
 */
public class Category {
    String category_name;
    Double category_rate;

    public Category(String category_name, Double category_rate) {
        this.category_name = category_name;
        this.category_rate = category_rate;
    }

    public String getCategory_name() {
        return category_name;
    }

    public Double getCategory_rate() {
        return category_rate;
    }

    public Category(Category category) {
        this.category_name = category.getCategory_name();
        this.category_rate = category.getCategory_rate();
    }
}
