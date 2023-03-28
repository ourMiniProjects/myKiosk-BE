package ourminiprojects.mykiosk.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourminiprojects.mykiosk.member.dto.MembersLoginRequestDto;
import ourminiprojects.mykiosk.member.dto.MembersResponseMsgDto;
import ourminiprojects.mykiosk.member.dto.MembersSignupRequestDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MembersController {

    private final MembersService membersService;

    @PostMapping("/signup")
    public MembersResponseMsgDto signup(@RequestBody MembersSignupRequestDto membersSignupRequestDto, HttpServletResponse response) {
        return membersService.signup(membersSignupRequestDto, response);
    }

    @PostMapping("/login")
    public MembersResponseMsgDto login(@RequestBody MembersLoginRequestDto membersLoginRequestDto, HttpServletResponse response) {
        return membersService.login(membersLoginRequestDto, response);
    }
}
