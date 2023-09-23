package com.cw.pinki.common.token;

import com.cw.pinki.common.vo.Brand;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "verification_token")
public class VerificationToken {
    private static final int EXPIRATION = 10; // 10分鐘失效

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = Brand.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "brand_id", referencedColumnName ="brand_no")
    private Brand brand;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Transient
    private boolean isExpired;

    public boolean isExpired(){
        return getExpiryDate().isBefore(LocalDateTime.now());
    }

    public VerificationToken(String token, Brand brand) {
        this.token = token;
        this.brand = brand;
        this.expiryDate = calculateExpiryDate();
    }

    public VerificationToken() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDateTime getExpiryDate() {
        return calculateExpiryDate();
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    private LocalDateTime calculateExpiryDate() {
        LocalDateTime time = LocalDateTime.now();
        return time.plusMinutes(VerificationToken.EXPIRATION);
    }
}


