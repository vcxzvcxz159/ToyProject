package com.example.toyproject.domain.repository;

import com.example.toyproject.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor {

    List<Item> findByItemNm(String itemNm);

    // @Query 를 이용한 조회
    @Query("select i from Item i Where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // @Query nativeQuery 를 이용한 조회
    @Query(value="select * from Item i where i.item_detail" +
           " like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String ItemDetail);

}
