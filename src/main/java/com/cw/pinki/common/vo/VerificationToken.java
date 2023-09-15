package com.cw.pinki.common.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION = 10; // 10分鐘失效

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String token;

    private Brand brand;

    private Member member;


    private LocalDateTime calculateExpiryDate(int expireMinutes) {
        LocalDateTime time = LocalDateTime.now();
        return time.plusMinutes(EXPIRATION);
    }
}


