package ourminiprojects.mykiosk.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MembersSignupRequestDto {
    private String phoneNumber;
    private boolean smsAgreement;
}
