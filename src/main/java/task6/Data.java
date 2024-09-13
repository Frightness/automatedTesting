package task6;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @ElementCollection
    @CollectionTable(name = "favorite_numbers", joinColumns = @JoinColumn(name = "data_id"))
    @Column(name = "favorite_number")
    private List<Integer> favoriteNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(List<Integer> favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favoriteNumber=" + favoriteNumber +
                '}';
    }
}
