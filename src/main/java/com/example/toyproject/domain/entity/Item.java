package com.example.toyproject.domain.entity;

import com.example.toyproject.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long id;                        // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm;                  // 상품명

    @Column(name = "price", nullable = false)
    private int price;                      // 상품가격

    @Column(nullable = false)
    private int stockNumber;                // 재고 수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;              // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  // 상품 판매 상태

    private LocalDateTime regTime;          // 상품 등록 시간
    private LocalDateTime updateTime;       // 상품 수정 시간
}
