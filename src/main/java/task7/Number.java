package task7;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "number")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int value;

    @Column
    private String description;

    // OneToOne
    @OneToOne(mappedBy = "number", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Data data;

    // ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_id")
    private Data dataOneToMany;

    // ManyToMany
    @ManyToMany(mappedBy = "manyToManyNumbers", fetch = FetchType.LAZY)
    private List<Data> dataList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getDataOneToMany() {
        return dataOneToMany;
    }

    public void setDataOneToMany(Data dataOneToMany) {
        this.dataOneToMany = dataOneToMany;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}
