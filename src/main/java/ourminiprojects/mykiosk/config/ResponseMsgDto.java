package ourminiprojects.mykiosk.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMsgDto {

    private String msg;
    private int httpStatus;

    public ResponseMsgDto(String msg, int httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
