package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Data;

@Data
public class UserResponseObject {
    private User user;
    private Error error;
    private String status;
}
