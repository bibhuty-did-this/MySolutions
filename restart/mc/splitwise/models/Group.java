package restart.mc.splitwise.models;

import java.util.List;

public class Group {
    private final String name, description, imageUrl;
    private final List<String> userList;

    public Group(String name, String description, String imageUrl, List<String> userList) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.userList = userList;
    }

    public List<String> getUserList() {
        return userList;
    }
}
