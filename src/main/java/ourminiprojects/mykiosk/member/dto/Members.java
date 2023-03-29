package ourminiprojects.mykiosk.member.dto;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer point = 0;

    @Column(nullable = false)
    private Boolean smsAgreement;

    public Members(MembersSignupRequestDto membersSignupRequestDto) {
        this.phoneNumber = membersSignupRequestDto.getPhoneNumber();
        this.smsAgreement = membersSignupRequestDto.isSmsAgreement();
    }
}
