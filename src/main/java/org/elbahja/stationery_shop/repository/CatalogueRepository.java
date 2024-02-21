package org.elbahja.stationery_shop.repository;

import org.elbahja.stationery_shop.model.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<CatalogueItem, Long>{

}
