package jsp.LoginException;

public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException() {
        super("가입되지 않은 이메일 입니다.");
    }
}
