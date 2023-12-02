package com.shopkart.inventoryService.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = Inventory.TABLE_NAME)
public class Inventory {

    public static final String TABLE_NAME="INVENTORY";
    public static final String SEQ_GEN_ALIAS="seq_gen_alias";
    public static final String SEQ_GEN_STRATEGY="uuid2";

    @Id
    @Column(name="INVENTORY_ID")
    @GeneratedValue(generator = SEQ_GEN_ALIAS)
    @GenericGenerator(name=SEQ_GEN_ALIAS,strategy = SEQ_GEN_STRATEGY)
    private String inventoryId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "MERCHANT_ID")
    private String merchantId;

    @Column(name = "STOCK")
    private Long stock;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "LISTING_PRICE")
    private Float listingPrice;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;





}
