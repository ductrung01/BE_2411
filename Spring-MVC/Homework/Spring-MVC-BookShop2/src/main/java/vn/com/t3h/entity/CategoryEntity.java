package vn.com.t3h.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    public CategoryEntity() {
    }
   @OneToMany (mappedBy = "category",fetch = FetchType.LAZY)
    private Set<ProductEntity> products;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
