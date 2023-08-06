package jsp.CustomException.LoginException;

public class IllegalPasswordException extends RuntimeException{
    public IllegalPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
