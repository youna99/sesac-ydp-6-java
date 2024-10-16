package codingon.spring_boot_jpa_practice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    @Column(nullable = false, length = 10)
    private String writer;

    @Column(name = "register", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime register;

    @PrePersist
    protected void onCreate() {
        register = LocalDateTime.now();
    }
}
