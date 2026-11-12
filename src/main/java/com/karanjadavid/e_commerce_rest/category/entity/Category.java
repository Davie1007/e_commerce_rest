package com.karanjadavid.e_commerce_rest.category.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseJpaEntity {

    private String name;

    private List<String> imageUrls;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> subCategories = new ArrayList<>();

    public void addSubcategory(Category subcategory) {
        subCategories.add(subcategory);
        subcategory.setParent(this);
    }

    public void removeSubcategory(Category subcategory) {
        subCategories.remove(subcategory);
        subcategory.setParent(null);
    }

}
