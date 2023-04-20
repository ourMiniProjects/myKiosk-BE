package ourminiprojects.mykiosk.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourminiprojects.mykiosk.member.service.MembersService;
import ourminiprojects.mykiosk.member.dto.MembersLoginRequestDto;
import ourminiprojects.mykiosk.config.ResponseMsgDto;
import ourminiprojects.mykiosk.member.dto.MembersSignupRequestDto;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MembersController {

    private final MembersService membersService;

    @PostMapping("/signup")
    public ResponseMsgDto signup(@RequestBody MembersSignupRequestDto membersSignupRequestDto, HttpServletResponse response) {
        return membersService.signup(membersSignupRequestDto, response);
    }

    @PostMapping("/login")
    public ResponseMsgDto login(@RequestBody MembersLoginRequestDto membersLoginRequestDto, HttpServletResponse response) {
        return membersService.login(membersLoginRequestDto, response);
    }
}
