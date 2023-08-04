package jsp.servlet.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jsp.servlet.service.MemberService;

@Path("/test")
public class MemberController {

    private final static MemberService memberService = new MemberService();

    @POST
    public void join() {

    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String login(){
        return "Hello API Service";
    }


}
