package app.web.pavelk.server7;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Path("/1")
public class GreetingResource {

    List<User> users;
    Integer id = 4;

    public GreetingResource() {
        users = new ArrayList<>();
        users.add(User.builder().id(1).name("Bob").email("d@g").state("N").code("432").zip(133).build());
        users.add(User.builder().id(2).name("Jon").email("d@y").state("F").code("465").zip(534).build());
        users.add(User.builder().id(3).name("Ford").email("a@r").state("H").code("654").zip(654).build());
        users.add(User.builder().id(4).name("Tom").email("d@t").state("G").code("23").zip(23).build());
    }

    @GET
    public List<User> list() {
        return users;
    }

    @POST
    public List<User> add(User user) {
        System.out.println(user);
        user.setZip(ThreadLocalRandom.current().nextInt());
        user.setId(++id);
        users.add(user);
        return users;
    }

    @DELETE
    public List<User> delete(User user) {
        System.out.println(user);
        users.removeIf(existingUser -> existingUser.getId().equals(user.getId()));
        return users;
    }

}