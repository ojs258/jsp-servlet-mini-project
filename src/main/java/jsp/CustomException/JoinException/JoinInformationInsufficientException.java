package jsp.CustomException.JoinException;

public class JoinInformationInsufficientException extends RuntimeException{
    //회원가입에 필요한 정보 불충분 예외

    public JoinInformationInsufficientException() {
        super("회원가입에 필요한 정보가 부족합니다.");
    }
}
