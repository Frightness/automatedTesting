package task7;

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

    // OneToOne
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "number_id")
    private Number number;

    // OneToMany
    @OneToMany(mappedBy = "data", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Number> numbers;

    // ManyToMany
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "data_number",
            joinColumns = @JoinColumn(name = "data_id"),
            inverseJoinColumns = @JoinColumn(name = "number_id")
    )
    private List<Number> manyToManyNumbers;

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

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getManyToManyNumbers() {
        return manyToManyNumbers;
    }

    public void setManyToManyNumbers(List<Number> manyToManyNumbers) {
        this.manyToManyNumbers = manyToManyNumbers;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favoriteNumber=" + favoriteNumber +
                ", number=" + number +
                ", numbers=" + numbers +
                ", manyToManyNumbers=" + manyToManyNumbers +
                '}';
    }
}
