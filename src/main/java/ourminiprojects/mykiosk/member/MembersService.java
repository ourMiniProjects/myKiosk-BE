package ourminiprojects.mykiosk.member;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ourminiprojects.mykiosk.member.dto.Members;
import ourminiprojects.mykiosk.member.dto.MembersLoginRequestDto;
import ourminiprojects.mykiosk.member.dto.MembersResponseMsgDto;
import ourminiprojects.mykiosk.member.dto.MembersSignupRequestDto;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MembersService {
    private final MembersRepository membersRepository;

    //클라이언트 상태코드 수정을 위해 사용함
    public void membersExceptionHandler(HttpServletResponse response, int statusCode) {
        //setStatus를 통해 response의 상태 코드 set
        response.setStatus(statusCode);
        //콘텐츠 유형을 json으로 바꿔줌
        response.setContentType("application/json");
    }

    //위 핸들러를 쓰고 dto로 리턴하기
    private MembersResponseMsgDto handleMemberException(String message, HttpStatus status, HttpServletResponse response) {
        membersExceptionHandler(response, status.value());
        return new MembersResponseMsgDto(message, status.value());
    }

    @Transactional
    public MembersResponseMsgDto signup(MembersSignupRequestDto membersSignupRequestDto, HttpServletResponse response) {
        String phoneNumber = membersSignupRequestDto.getPhoneNumber();


        Members found = membersRepository.findByPhoneNumber(membersSignupRequestDto.getPhoneNumber());

        if (found != null) {
            return handleMemberException("이미 등록된 번호입니다", HttpStatus.BAD_REQUEST, response);
        }

        String regExp = "^010(\\d{4})(\\d{4})$";

        if(!phoneNumber.matches(regExp)){
            return  handleMemberException("번호를 다시 확인해 주십시오", HttpStatus.BAD_REQUEST, response);
        }

        Members members = new Members(membersSignupRequestDto);
        membersRepository.saveAndFlush(members);

        return handleMemberException("가입되었습니다", HttpStatus.OK, response);

    }

    public MembersResponseMsgDto login(MembersLoginRequestDto membersLoginRequestDto, HttpServletResponse response) {
        Members found = membersRepository.findByPhoneNumber(membersLoginRequestDto.getPhoneNumber());
        String regExp = "^010(\\d{4})(\\d{4})$";

        if (!membersLoginRequestDto.getPhoneNumber().matches(regExp)) {
            return handleMemberException("번호를 확인해 주십시오", HttpStatus.BAD_REQUEST, response);
        }

        if (found == null) {
            return handleMemberException("가입되지 않은 번호입니다", HttpStatus.BAD_REQUEST, response);
        }

        return handleMemberException("로그인 성공", HttpStatus.OK, response);
    }
}
