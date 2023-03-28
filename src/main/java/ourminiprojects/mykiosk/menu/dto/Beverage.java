package ourminiprojects.mykiosk.menu.dto;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String beverageName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String imageUrl;
}
