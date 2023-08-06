package jsp.CustomException.JoinException;

public class EmailDuplicatedException extends RuntimeException{

    public EmailDuplicatedException() {
        super("이미 가입하신 이메일 입니다.");
    }
}
